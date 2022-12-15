package kr.company.api.api.department.application;


import kr.company.api.api.department.dto.DepartmentOrEmployeeResponse;
import kr.company.api.api.department.dto.DepartmentQuery;
import kr.company.api.api.department.repository.DepartmentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentHistoryService {

    private final DepartmentHistoryRepository departmentHistoryRepository;

    @Transactional(readOnly = true)
    public List<DepartmentOrEmployeeResponse> findAllHistoryByQueryForTree(DepartmentQuery query) {
        return departmentHistoryRepository.findAllByQueryForTree(query);
    }
}