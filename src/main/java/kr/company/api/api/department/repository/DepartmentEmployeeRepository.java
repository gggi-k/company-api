package kr.company.api.api.department.repository;


import kr.company.api.api.department.domain.entity.DepartmentEmployeeEntity;
import kr.company.api.api.department.domain.vo.DepartmentEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployeeEntity, DepartmentEmployeeId> {

}