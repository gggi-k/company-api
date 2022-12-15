package kr.company.api.api.department.repository;

import kr.company.api.api.department.domain.entity.DepartmentEmployeeHistoryEntity;
import kr.company.api.api.department.domain.vo.DepartmentEmployeeHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentEmployeeHistoryRepository extends JpaRepository<DepartmentEmployeeHistoryEntity, DepartmentEmployeeHistoryId> {

    @Modifying
    @Query(nativeQuery = true,
        value = "INSERT INTO DEPARTMENT_EMPLOYEE_HISTORY(DEPARTMENT_ID, EMPLOYEE_ID, HISTORY_DATE, POSITION_CODE) " +
                "SELECT DEPARTMENT_ID, EMPLOYEE_ID, CURRENT_DATE, POSITION_CODE FROM DEPARTMENT_EMPLOYEE"
    )
    int copyDepartmentEmployeeForHistory();
}