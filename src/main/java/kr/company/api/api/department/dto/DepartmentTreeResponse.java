package kr.company.api.api.department.dto;


import kr.company.api.api.corporation.dto.CorporationResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Getter
public class DepartmentTreeResponse {

    private final CorporationResponse corporation;
    private final List<DepartmentOrEmployeeResponse> list;

    public Map<Long, List<DepartmentOrEmployeeResponse>> getTree() {
        return this.list.stream()
                .collect(Collectors.groupingBy(DepartmentOrEmployeeResponse::getUpperDepartmentId));
    }

}