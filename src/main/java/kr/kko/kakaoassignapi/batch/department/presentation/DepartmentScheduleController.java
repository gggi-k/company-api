package kr.kko.kakaoassignapi.batch.department.presentation;

import kr.kko.kakaoassignapi.batch.department.schedule.DepartmentScheduled;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DepartmentScheduleController {

    private final DepartmentScheduled departmentScheduled;

    @GetMapping("/api/department-history")
    public void createDepartmentHistory() {
        departmentScheduled.createDepartmentHistory();
    }

    @GetMapping("/api/department-employee-history")
    public void createDepartmentEmployeeHistory() {
        departmentScheduled.createDepartmentEmployeeHistory();
    }
}