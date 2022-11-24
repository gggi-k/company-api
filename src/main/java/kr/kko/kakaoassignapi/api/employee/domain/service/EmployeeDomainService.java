package kr.kko.kakaoassignapi.api.employee.domain.service;

import kr.kko.kakaoassignapi.api.employee.dto.EmployeeRequest;
import kr.kko.kakaoassignapi.api.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmployeeDomainService {

    private final EmployeeRepository employeeRepository;

    public boolean isDuplicateEmployeeId(String employeeId) {
        return employeeRepository.existsById(employeeId);
    }

}