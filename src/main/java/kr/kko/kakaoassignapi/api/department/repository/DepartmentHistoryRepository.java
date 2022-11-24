package kr.kko.kakaoassignapi.api.department.repository;

import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentHistoryEntity;
import kr.kko.kakaoassignapi.api.department.domain.vo.DepartmentHistoryId;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentOrEmployeeResponse;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DepartmentHistoryRepository extends JpaRepository<DepartmentHistoryEntity, DepartmentHistoryId>, NoPagingForTreeRepositoryTemplate<DepartmentOrEmployeeResponse, DepartmentQuery> {

    List<DepartmentHistoryEntity> findAllByCorporationIdAndDepartmentHistoryId_HistoryDate(Long corporationId, LocalDate historyDate);

    @Modifying
    @Query(nativeQuery = true,
        value = "INSERT INTO DEPARTMENT_HISTORY(DEPARTMENT_ID, HISTORY_DATE, DEPARTMENT_NAME, UPPER_DEPARTMENT_ID, CORPORATION_ID) " +
                "SELECT DEPARTMENT_ID, CURRENT_DATE, DEPARTMENT_NAME, UPPER_DEPARTMENT_ID, CORPORATION_ID FROM DEPARTMENT"
    )
    int copyDepartmentForHistory();
}