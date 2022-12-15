package kr.company.api.api.employee.domain.entity;


import kr.company.api.core.jpa.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
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

    @Comment("사번")
    @Column(name = "EMPLOYEE_NUMBER")
    private String employeeNumber;

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