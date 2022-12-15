package kr.company.api.api.department.repository;


import kr.company.api.api.department.domain.entity.DepartmentEntity;
import kr.company.api.api.department.dto.DepartmentOrEmployeeResponse;
import kr.company.api.api.department.dto.DepartmentQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>, NoPagingForTreeRepositoryTemplate<DepartmentOrEmployeeResponse, DepartmentQuery> {

    List<DepartmentEntity> findAllByCorporationId(Long corporationId);
}