package kr.company.api.core.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Login {

    @NotBlank
    private String employeeId;

    @NotBlank
    private String password;
}