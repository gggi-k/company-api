package kr.company.api.api.corporation.application;

import kr.company.api.api.corporation.domain.CorporationEntity;
import kr.company.api.api.corporation.dto.CorporationResponse;
import kr.company.api.api.corporation.repository.CorporationRepository;
import kr.company.api.core.error.NotFoundException;
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

    public CorporationResponse findById(Long corporationId) {
        return CorporationResponse.fromEntity(corporationRepository.findById(corporationId).orElseThrow(() -> new NotFoundException("해당하는 법인이 존재하지 않습니다")));
    }

    public List<CorporationResponse> findAll() {
        return CorporationResponse.fromEntities(corporationRepository.findAll(Sort.by(Sort.Order.asc(CorporationEntity.Fields.corporationName))));
    }
}