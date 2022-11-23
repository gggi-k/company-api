package kr.kko.kakaoassignapi.api.department.dto;

import kr.kko.kakaoassignapi.api.corporation.domain.CorporationEntity;
import kr.kko.kakaoassignapi.api.corporation.dto.CorporationResponse;
import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentEntity;
import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentHistoryEntity;
import kr.kko.kakaoassignapi.api.department.domain.vo.DepartmentHistoryId;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Getter
@ToString
public class DepartmentResponse {

    @Mapper
    public interface Mappers {
        DepartmentResponse.Mappers INSTANCE = org.mapstruct.factory.Mappers.getMapper(DepartmentResponse.Mappers.class);

        @Mapping(target = "upperDepartmentId", source = "upperDepartmentId", defaultValue = "0")
        DepartmentResponse fromEntity(DepartmentEntity departmentEntity);

        @Mapping(target = "departmentId", source = "departmentHistoryId.departmentId")
        @Mapping(target = "upperDepartmentId", source = "upperDepartmentId", defaultValue = "0")
        DepartmentResponse fromHistoryEntity(DepartmentHistoryEntity departmentHistoryEntity);
    }

    private final Long departmentId;
    private final String departmentName;
    private final Long upperDepartmentId;
    private final Long corporationId;

    public static DepartmentResponse fromEntity(DepartmentEntity departmentEntity) {
        return Mappers.INSTANCE.fromEntity(departmentEntity);
    }

    public static DepartmentResponse fromHistoryEntity(DepartmentHistoryEntity departmentHistoryEntity) {
        return Mappers.INSTANCE.fromHistoryEntity(departmentHistoryEntity);
    }

    public static Map<Long, List<DepartmentResponse>> fromEntities (List<DepartmentEntity> departmentEntities) {
        return departmentEntities
                .stream()
                .map(DepartmentResponse::fromEntity)
                .collect(Collectors.groupingBy(DepartmentResponse::getUpperDepartmentId));
    }

    public static Map<Long, List<DepartmentResponse>> fromHistoryEntities (List<DepartmentHistoryEntity> departmentHistoryEntities) {
        return departmentHistoryEntities
                .stream()
                .map(DepartmentResponse::fromHistoryEntity)
                .collect(Collectors.groupingBy(DepartmentResponse::getUpperDepartmentId));
    }



}