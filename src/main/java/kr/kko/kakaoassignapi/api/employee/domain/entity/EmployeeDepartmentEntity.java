package kr.kko.kakaoassignapi.api.employee.domain.entity;

import kr.kko.kakaoassignapi.api.department.domain.code.PositionCode;
import kr.kko.kakaoassignapi.api.employee.application.EmployeeService;
import kr.kko.kakaoassignapi.api.employee.domain.vo.EmployeeDepartmentId;
import kr.kko.kakaoassignapi.core.jpa.entity.CreatedEntity;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "EMPLOYEE_DEPARTMENT")
public class EmployeeDepartmentEntity extends CreatedEntity {

    @EmbeddedId
    private EmployeeDepartmentId employeeDepartmentId;

    @Enumerated(EnumType.STRING)
    private PositionCode positionCode;

    @Comment("삭제일시")
    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;

}