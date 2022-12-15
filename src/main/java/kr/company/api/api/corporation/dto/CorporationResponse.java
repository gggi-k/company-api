package kr.company.api.api.corporation.dto;


import kr.company.api.api.corporation.domain.CorporationEntity;
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
        CorporationResponse.Mappers INSTANCE = org.mapstruct.factory.Mappers.getMapper(CorporationResponse.Mappers.class);
        CorporationResponse fromEntity(CorporationEntity corporationEntity);
    }

    private final Long corporationId;
    private final String corporationName;

    public static CorporationResponse fromEntity(CorporationEntity corporationEntity) {
        return Mappers.INSTANCE.fromEntity(corporationEntity);
    }

    public static List<CorporationResponse> fromEntities(List<CorporationEntity> corporationEntities) {
        return corporationEntities.stream().map(CorporationResponse::fromEntity).collect(Collectors.toList());
    }
}