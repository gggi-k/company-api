package kr.kko.kakaoassignapi.api.corporation.application;

import kr.kko.kakaoassignapi.api.corporation.domain.CorporationEntity;
import kr.kko.kakaoassignapi.api.corporation.dto.CorporationResponse;
import kr.kko.kakaoassignapi.api.corporation.repository.CorporationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CorporationService {

    private final CorporationRepository corporationRepository;

    public List<CorporationResponse> findAll() {
        return CorporationResponse.fromEntities(corporationRepository.findAll(Sort.by(Sort.Order.asc(CorporationEntity.Fields.corporationName))));
    }
}