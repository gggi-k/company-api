package kr.company.api.api.department.dto;

import kr.company.api.api.department.domain.code.PositionCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldNameConstants
@Getter
@ToString
public class DepartmentOrEmployeeResponse {

    private Long corporationId;
    private Long departmentId;
    private String departmentName;
    private Long upperDepartmentId;
    private boolean isEmployee;
    private String employeeId;
    private String employeeName;
    private String employeeNumber;
    private LocalDate birthDay;
    private PositionCode positionCode;
    private LocalDate joinDate;
    private LocalDate retireDate;

    public Long getUpperDepartmentId() {
        return this.upperDepartmentId == null ? 0L : this.upperDepartmentId;
    }

    public String getPositionName() {
        if(this.positionCode == null) return null;

        return this.positionCode.getName();
    }

    public String getTitle() {
        return this.isEmployee ? this.employeeName : this.departmentName;
    }

    @EqualsAndHashCode.Include
    public String getKey() {
        StringBuilder sb = new StringBuilder("department-")
                .append(this.departmentId);

        if(isEmployee) {
            sb.append("-employee-")
            .append(this.employeeId);
        }

        return sb.toString();
    }

}