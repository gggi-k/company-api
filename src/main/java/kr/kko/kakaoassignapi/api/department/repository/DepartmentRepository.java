package kr.kko.kakaoassignapi.api.department.repository;

import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentEntity;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentOrEmployeeResponse;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import kr.kko.kakaoassignapi.core.jpa.template.NoPagingRepositoryTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>, NoPagingForTreeRepositoryTemplate<DepartmentOrEmployeeResponse, DepartmentQuery> {

    List<DepartmentEntity> findAllByCorporationId(Long corporationId);
}