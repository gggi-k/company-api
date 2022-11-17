package kr.kko.kakaoassignapi.api.corporation.dto;

import kr.kko.kakaoassignapi.api.corporation.domain.CorporationEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@ToString
public class CorporationResponse {

    @Mapper
    public interface Mappers {
        CorporationResponse$MappersImpl FACTORY = new CorporationResponse$MappersImpl();
        CorporationResponse fromEntity(CorporationEntity corporationEntity);
    }

    private final Long corporationId;
    private final String corporationName;

    public static CorporationResponse fromEntity(CorporationEntity corporationEntity) {
        return Mappers.FACTORY.fromEntity(corporationEntity);
    }

    public static List<CorporationResponse> fromEntities(List<CorporationEntity> corporationEntities) {
        return corporationEntities.stream().map(CorporationResponse::fromEntity).collect(Collectors.toList());
    }
}