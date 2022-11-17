package kr.kko.kakaoassignapi.api.corporation.repository;

import kr.kko.kakaoassignapi.api.corporation.domain.CorporationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationRepository extends JpaRepository<CorporationEntity, Long> {
}