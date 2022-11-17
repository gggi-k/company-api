package kr.kko.kakaoassignapi.api.employee.domain.entity;

import kr.kko.kakaoassignapi.api.department.domain.code.PositionCode;
import kr.kko.kakaoassignapi.api.employee.application.EmployeeService;
import kr.kko.kakaoassignapi.api.employee.domain.vo.EmployeeDepartmentId;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "EMPLOYEE_DEPARTMENT")
public class EmployeeDepartmentEntity {

    @EmbeddedId
    private EmployeeDepartmentId employeeDepartmentId;

    @Enumerated(EnumType.STRING)
    private PositionCode positionCode;
}