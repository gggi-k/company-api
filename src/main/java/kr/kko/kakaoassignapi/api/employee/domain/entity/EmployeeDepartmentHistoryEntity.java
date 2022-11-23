package kr.kko.kakaoassignapi.api.employee.domain.entity;

import kr.kko.kakaoassignapi.api.department.domain.code.PositionCode;
import kr.kko.kakaoassignapi.api.employee.domain.vo.EmployeeDepartmentId;
import kr.kko.kakaoassignapi.core.jpa.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "EMPLOYEE_DEPARTMENT_HISTORY")
public class EmployeeDepartmentHistoryEntity {

    @EmbeddedId
    private EmployeeDepartmentId employeeDepartmentId;

    @Enumerated(EnumType.STRING)
    @Comment("직책코드")
    @Column(name = "POSITION_CODE")
    private PositionCode positionCode;

}