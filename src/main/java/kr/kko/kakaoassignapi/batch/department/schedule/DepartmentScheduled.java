package kr.kko.kakaoassignapi.batch.department.schedule;

import kr.kko.kakaoassignapi.api.department.repository.DepartmentEmployeeHistoryRepository;
import kr.kko.kakaoassignapi.api.department.repository.DepartmentEmployeeRepository;
import kr.kko.kakaoassignapi.api.department.repository.DepartmentHistoryRepository;
import kr.kko.kakaoassignapi.api.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DepartmentScheduled {

    private final DepartmentHistoryRepository departmentHistoryRepository;
    private final DepartmentEmployeeHistoryRepository departmentEmployeeHistoryRepository;

    @Scheduled(cron = "@daily")
    public void createDepartmentHistory() {
        int count = departmentHistoryRepository.copyDepartmentForHistory();
        log.info("createDepartmentHistory count = {}", count);
    }

    @Scheduled(cron = "@daily")
    public void createDepartmentEmployeeHistory() {
        int count = departmentEmployeeHistoryRepository.copyDepartmentEmployeeForHistory();
        log.info("createDepartmentEmployeeHistory count = {}", count);
    }
}