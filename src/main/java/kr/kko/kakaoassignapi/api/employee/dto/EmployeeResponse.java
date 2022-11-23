package kr.kko.kakaoassignapi.api.employee.dto;

import kr.kko.kakaoassignapi.api.employee.domain.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class EmployeeResponse {

    @Mapper
    interface Mappers {
        EmployeeResponse.Mappers INSTANCE = org.mapstruct.factory.Mappers.getMapper(EmployeeResponse.Mappers.class);
        EmployeeResponse fromEntity(EmployeeEntity employeeEntity);
    }

    private final String employeeId;
    private final String password;
    private final String name;
    private final LocalDate birthDay;
    private final LocalDate joinDate;
    private final LocalDate retireDate;

    public static EmployeeResponse fromEntity(EmployeeEntity employeeEntity) {
        return Mappers.INSTANCE.fromEntity(employeeEntity);
    }
}