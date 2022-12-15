package kr.company.api.api.corporation.repository;


import kr.company.api.api.corporation.domain.CorporationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationRepository extends JpaRepository<CorporationEntity, Long> {
}