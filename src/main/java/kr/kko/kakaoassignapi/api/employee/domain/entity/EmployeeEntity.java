package kr.kko.kakaoassignapi.api.employee.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    private String employeeId;

    private String password;

    private String name;

    private LocalDate birthDay;

    private LocalDate joinDate;

    private LocalDate retireDate;

}