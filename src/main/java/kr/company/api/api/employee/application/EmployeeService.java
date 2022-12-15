package kr.company.api.api.employee.application;


import kr.company.api.api.employee.domain.entity.EmployeeEntity;
import kr.company.api.api.employee.domain.service.EmployeeDomainService;
import kr.company.api.api.employee.dto.EmployeeRequest;
import kr.company.api.api.employee.dto.EmployeeResponse;
import kr.company.api.api.employee.repository.EmployeeRepository;
import kr.company.api.core.error.DuplicateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDomainService employeeDomainService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeResponse create(EmployeeRequest request) {

        if(employeeDomainService.isDuplicateEmployeeId(request.getEmployeeId())) throw new DuplicateException("중복된 유저아이디가 존재합니다");

        return EmployeeResponse.fromEntity(employeeRepository.save(EmployeeEntity.builder()
                .employeeId(request.getEmployeeId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .birthDay(request.getBirthDay())
                .joinDate(request.getJoinDate())
                .build()));
    }
}