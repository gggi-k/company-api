package kr.kko.kakaoassignapi.api.department.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentOrEmployeeResponse;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static kr.kko.kakaoassignapi.api.department.domain.entity.QDepartmentEmployeeHistoryEntity.departmentEmployeeHistoryEntity;
import static kr.kko.kakaoassignapi.api.department.domain.entity.QDepartmentHistoryEntity.departmentHistoryEntity;
import static kr.kko.kakaoassignapi.api.employee.domain.entity.QEmployeeEntity.employeeEntity;

@RequiredArgsConstructor
@Repository
public class DepartmentHistoryRepositoryImpl implements NoPagingForTreeRepositoryTemplate<DepartmentOrEmployeeResponse, DepartmentQuery> {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DepartmentOrEmployeeResponse> findAllByQueryForTree(DepartmentQuery query) {
        final List<DepartmentOrEmployeeResponse> list = new ArrayList<>();

        final List<DepartmentOrEmployeeResponse> employees = jpaQueryFactory.select(Projections.fields(
                DepartmentOrEmployeeResponse.class,
                departmentHistoryEntity.corporationId,
                departmentHistoryEntity.departmentHistoryId.departmentId,
                departmentHistoryEntity.departmentName,
                departmentHistoryEntity.upperDepartmentId,
                Expressions.asBoolean(true).as(DepartmentOrEmployeeResponse.Fields.isEmployee),
                employeeEntity.employeeId,
                employeeEntity.name.as(DepartmentOrEmployeeResponse.Fields.employeeName),
                employeeEntity.employeeNumber,
                employeeEntity.birthDay,
                departmentEmployeeHistoryEntity.positionCode,
                employeeEntity.joinDate,
                employeeEntity.retireDate
        ))
                .from(departmentHistoryEntity)
                .innerJoin(departmentEmployeeHistoryEntity)
                .on(departmentHistoryEntity.departmentHistoryId.departmentId.eq(departmentEmployeeHistoryEntity.departmentEmployeeHistoryId.departmentId)
                    .and(departmentHistoryEntity.departmentHistoryId.historyDate.eq(departmentEmployeeHistoryEntity.departmentEmployeeHistoryId.historyDate)))
                .innerJoin(employeeEntity)
                .on(departmentEmployeeHistoryEntity.departmentEmployeeHistoryId.employeeId.eq(employeeEntity.employeeId))
                .where(containsEmployeeName(query.getSearchEmployeeName()),
                        departmentHistoryEntity.departmentHistoryId.historyDate.eq(query.getSearchDate()),
                        employeeEntity.retireDate.isNull()
                                .or(employeeEntity.retireDate.isNotNull().and(employeeEntity.retireDate.before(LocalDate.now()))))
                .fetch();

        list.addAll(employees);

        final List<DepartmentOrEmployeeResponse> departments = jpaQueryFactory.select(Projections.fields(
                DepartmentOrEmployeeResponse.class,
                departmentHistoryEntity.corporationId,
                departmentHistoryEntity.departmentHistoryId.departmentId,
                departmentHistoryEntity.departmentName,
                departmentHistoryEntity.upperDepartmentId,
                Expressions.asBoolean(false).as(DepartmentOrEmployeeResponse.Fields.isEmployee)
        ))
                .from(departmentHistoryEntity)
                .where(departmentHistoryEntity.departmentHistoryId.historyDate.eq(query.getSearchDate()),
                    departmentHistoryEntity.corporationId.eq(query.getCorporationId()))
                .fetch();

        if(query.existSearchEmployeeName()) {
            Map<Long, List<DepartmentOrEmployeeResponse>> map = departments.stream().collect(Collectors.groupingBy(DepartmentOrEmployeeResponse::getDepartmentId));
            list.addAll(employees);
            list.addAll(recursiveDepartment(employees, map));
        } else {
            list.addAll(departments);
        }

        return list;
    }

    private BooleanExpression containsEmployeeName(String employeeName) {
        if(!StringUtils.hasText(employeeName)) return null;

        return employeeEntity.name.containsIgnoreCase(employeeName);
    }

    private List<DepartmentOrEmployeeResponse> recursiveDepartment(List<DepartmentOrEmployeeResponse> contain, Map<Long, List<DepartmentOrEmployeeResponse>> map) {
        if(contain.isEmpty()) return Collections.emptyList();

        final List<DepartmentOrEmployeeResponse> parent = new ArrayList<>();
        for (DepartmentOrEmployeeResponse response : contain) {
            final Long upperDepartmentId = response.getUpperDepartmentId();
            if(upperDepartmentId == null || !map.containsKey(upperDepartmentId)) continue;

            parent.addAll(map.get(upperDepartmentId));
        }

        parent.addAll(recursiveDepartment(new ArrayList<>(parent), map));

        return parent;
    }
}