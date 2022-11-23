package kr.kko.kakaoassignapi.api.department.presentation;

import kr.kko.kakaoassignapi.api.department.application.DepartmentService;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentQuery;
import kr.kko.kakaoassignapi.api.department.dto.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public Map<Long, List<DepartmentResponse>> findAllForTree(DepartmentQuery query) {
        return departmentService.findAllForTree(query);
    }
}