package kr.kko.kakaoassignapi.api.department.repository;

import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentEntity;
import kr.kko.kakaoassignapi.core.jpa.template.NoPagingRepositoryTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}