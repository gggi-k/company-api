package kr.company.api.batch.department.schedule;

import kr.company.api.api.department.repository.DepartmentEmployeeHistoryRepository;
import kr.company.api.api.department.repository.DepartmentHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
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