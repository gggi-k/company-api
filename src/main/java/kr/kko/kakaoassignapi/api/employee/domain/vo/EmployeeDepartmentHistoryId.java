package kr.kko.kakaoassignapi.api.employee.domain.vo;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Getter
@ToString
@Embeddable
public class EmployeeDepartmentHistoryId implements Serializable {

    private static final long serialVersionUID = -6486010715465526756L;

    @Comment("사원아이디")
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Comment("부서아이디")
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Comment("이력일")
    @Column(name = "HISTORY_DATE")
    private LocalDate historyDate;
}