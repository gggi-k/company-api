package kr.company.api.api.department.presentation;

import kr.company.api.api.corporation.application.CorporationService;
import kr.company.api.api.department.application.DepartmentHistoryService;
import kr.company.api.api.department.application.DepartmentService;
import kr.company.api.api.department.dto.DepartmentQuery;
import kr.company.api.api.department.dto.DepartmentTreeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/corporation/{corporationId}/department")
public class DepartmentController {

    private final CorporationService corporationService;
    private final DepartmentService departmentService;
    private final DepartmentHistoryService departmentHistoryService;

    @GetMapping(params = "isHistory=false")
    public DepartmentTreeResponse findAllByQueryForTree(@PathVariable Long corporationId, DepartmentQuery query) {
        return DepartmentTreeResponse.builder()
                .corporation(corporationService.findById(corporationId))
                .list(departmentService.findAllByQueryForTree(query.setCorporationId(corporationId)))
                .build();
    }

    @GetMapping(params = "isHistory=true")
    public DepartmentTreeResponse findAllHistoryByQueryForTree(@PathVariable Long corporationId, @Validated DepartmentQuery query) {
        return DepartmentTreeResponse.builder()
                .corporation(corporationService.findById(corporationId))
                .list(departmentHistoryService.findAllHistoryByQueryForTree(query.setCorporationId(corporationId)))
                .build();
    }
}