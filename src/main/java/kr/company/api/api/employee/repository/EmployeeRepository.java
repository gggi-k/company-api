package kr.company.api.api.employee.repository;


import kr.company.api.api.employee.domain.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}