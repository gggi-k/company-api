package kr.kko.kakaoassignapi.api.employee.presentation;


import kr.kko.kakaoassignapi.api.employee.application.EmployeeService;
import kr.kko.kakaoassignapi.api.employee.dto.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sign-up")
public class SignupController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse signUp() {
        return null;
    }
}