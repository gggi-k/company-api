package kr.kko.kakaoassignapi.api.department.application;

import kr.kko.kakaoassignapi.api.department.dto.DepartmentOrEmployeeResponse;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import kr.kko.kakaoassignapi.api.department.repository.DepartmentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class DepartmentHistoryService {

    private final DepartmentHistoryRepository departmentHistoryRepository;

    @Transactional(readOnly = true)
    public List<DepartmentOrEmployeeResponse> findAllHistoryByQueryForTree(DepartmentQuery query) {
        return departmentHistoryRepository.findAllByQueryForTree(query);
    }
}