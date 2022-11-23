package kr.kko.kakaoassignapi.api.employee.application;

import kr.kko.kakaoassignapi.api.employee.domain.entity.EmployeeEntity;
import kr.kko.kakaoassignapi.api.employee.dto.EmployeeRequest;
import kr.kko.kakaoassignapi.api.employee.dto.EmployeeResponse;
import kr.kko.kakaoassignapi.api.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeResponse create(EmployeeRequest employeeRequest) {
        return EmployeeResponse.fromEntity(employeeRepository.save(EmployeeEntity.builder()
                .build()));
    }
}