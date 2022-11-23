package kr.kko.kakaoassignapi.api.employee.repository;

import kr.kko.kakaoassignapi.api.employee.domain.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}