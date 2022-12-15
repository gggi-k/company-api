package kr.company.api.api.department.application;


import kr.company.api.api.department.dto.DepartmentOrEmployeeResponse;
import kr.company.api.api.department.dto.DepartmentQuery;
import kr.company.api.api.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<DepartmentOrEmployeeResponse> findAllByQueryForTree(DepartmentQuery query) {
        return departmentRepository.findAllByQueryForTree(query);
    }
}