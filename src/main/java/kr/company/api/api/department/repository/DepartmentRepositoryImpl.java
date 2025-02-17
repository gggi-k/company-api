package kr.company.api.api.department.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.company.api.api.department.dto.DepartmentOrEmployeeResponse;
import kr.company.api.api.department.dto.DepartmentQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static kr.company.api.api.department.domain.entity.QDepartmentEmployeeEntity.departmentEmployeeEntity;
import static kr.company.api.api.department.domain.entity.QDepartmentEntity.departmentEntity;
import static kr.company.api.api.employee.domain.entity.QEmployeeEntity.employeeEntity;

@RequiredArgsConstructor
@Repository
public class DepartmentRepositoryImpl implements NoPagingForTreeRepositoryTemplate<DepartmentOrEmployeeResponse, DepartmentQuery> {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DepartmentOrEmployeeResponse> findAllByQueryForTree(DepartmentQuery query) {
        final List<DepartmentOrEmployeeResponse> list = new ArrayList<>();

        final List<DepartmentOrEmployeeResponse> employees = jpaQueryFactory.select(Projections.fields(
                    DepartmentOrEmployeeResponse.class,
                    departmentEntity.corporationId,
                    departmentEntity.departmentId,
                    departmentEntity.departmentName,
                    departmentEntity.upperDepartmentId,
                    Expressions.asBoolean(true).as(DepartmentOrEmployeeResponse.Fields.isEmployee),
                    employeeEntity.employeeId,
                    employeeEntity.name.as(DepartmentOrEmployeeResponse.Fields.employeeName),
                    employeeEntity.employeeNumber,
                    employeeEntity.birthDay,
                    departmentEmployeeEntity.positionCode,
                    employeeEntity.joinDate,
                    employeeEntity.retireDate
                ))
                .from(departmentEntity)
                .innerJoin(departmentEmployeeEntity)
                    .on(departmentEntity.departmentId.eq(departmentEmployeeEntity.departmentEmployeeId.departmentId))
                .innerJoin(employeeEntity)
                    .on(departmentEmployeeEntity.departmentEmployeeId.employeeId.eq(employeeEntity.employeeId))
                .where(containsEmployeeName(query.getSearchEmployeeName()),
                        employeeEntity.retireDate.isNull()
                                .or(employeeEntity.retireDate.isNotNull().and(employeeEntity.retireDate.after(LocalDate.now()))))
                .fetch();

        list.addAll(employees);

        final List<DepartmentOrEmployeeResponse> departments = jpaQueryFactory.select(Projections.fields(
                DepartmentOrEmployeeResponse.class,
                departmentEntity.corporationId,
                departmentEntity.departmentId,
                departmentEntity.departmentName,
                departmentEntity.upperDepartmentId,
                Expressions.asBoolean(false).as(DepartmentOrEmployeeResponse.Fields.isEmployee)
        ))
        .from(departmentEntity)
        .where(departmentEntity.corporationId.eq(query.getCorporationId()))
        .fetch();

        if(query.existSearchEmployeeName()) {
            Map<Long, List<DepartmentOrEmployeeResponse>> map = departments.stream().collect(Collectors.groupingBy(DepartmentOrEmployeeResponse::getDepartmentId));
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

    private Set<DepartmentOrEmployeeResponse> recursiveDepartment(List<DepartmentOrEmployeeResponse> contain, Map<Long, List<DepartmentOrEmployeeResponse>> map) {
        if(contain.isEmpty()) return Collections.emptySet();

        final Set<DepartmentOrEmployeeResponse> parent = new HashSet<>();
        for (DepartmentOrEmployeeResponse response : contain) {
            final Long upperDepartmentId = response.getUpperDepartmentId();
            if(upperDepartmentId == null || !map.containsKey(upperDepartmentId)) continue;

            parent.addAll(map.get(upperDepartmentId));
        }

        parent.addAll(recursiveDepartment(new ArrayList<>(parent), map));

        return parent;
    }
}