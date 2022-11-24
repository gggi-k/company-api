package kr.kko.kakaoassignapi.api.employee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor(staticName = "create")
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class EmployeeRequest {

    @NotBlank
    private String employeeId;
    private String password;

    private Long departmentId;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDay;

    @NotNull
    private LocalDate joinDate;

    private Long corporationId;
}