package kr.kko.kakaoassignapi.api.department.repository;

import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentEmployeeEntity;
import kr.kko.kakaoassignapi.api.department.domain.vo.DepartmentEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployeeEntity, DepartmentEmployeeId> {

}