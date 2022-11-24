package kr.kko.kakaoassignapi.api.employee.presentation;


import kr.kko.kakaoassignapi.api.employee.application.EmployeeService;
import kr.kko.kakaoassignapi.api.employee.domain.service.EmployeeDomainService;
import kr.kko.kakaoassignapi.api.employee.dto.EmployeeRequest;
import kr.kko.kakaoassignapi.api.employee.dto.EmployeeResponse;
import kr.kko.kakaoassignapi.core.error.DuplicateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/sign-up")
public class SignupController {

    private final EmployeeService employeeService;
    private final EmployeeDomainService employeeDomainService;

    @PostMapping
    public EmployeeResponse signUp(@RequestBody @Validated EmployeeRequest request) {
        return employeeService.create(request);
    }

    @GetMapping("/duplicate/employeeId/{employeeId}")
    public void isDuplicateByEmployeeId(@PathVariable String employeeId) {
        if(employeeDomainService.isDuplicateEmployeeId(employeeId)) throw new DuplicateException("중복되는 아이디가 존재합니다");
    }
}