package kr.kko.kakaoassignapi.api.employee.domain.entity;

import kr.kko.kakaoassignapi.api.department.domain.entity.DepartmentEntity;
import kr.kko.kakaoassignapi.core.jpa.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends BaseEntity {

    @Id
    @Comment("직원아이디")
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Comment("패스워드")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Comment("이름")
    @Column(name = "NAME", nullable = false)
    private String name;

    @Comment("생년월일")
    @Column(name = "BIRTH_DAY", updatable = false, nullable = false)
    private LocalDate birthDay;

    @Comment("입사일")
    @Column(name = "JOIN_DATE")
    private LocalDate joinDate;

    @Comment("퇴사일")
    @Column(name = "RETIRE_DATE")
    private LocalDate retireDate;

}