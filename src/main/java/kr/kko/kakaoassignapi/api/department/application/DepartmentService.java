package kr.kko.kakaoassignapi.api.department.application;

import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentResponse;
import kr.kko.kakaoassignapi.api.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Map<Long, List<DepartmentResponse>> findAllForTree(DepartmentQuery query) {

        return DepartmentResponse.fromEntities(departmentRepository.findAll());
    }
}