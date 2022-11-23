package kr.kko.kakaoassignapi.api.department.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@Table(name = "DEPARTMENT")
public class DepartmentEntity {

    @Id
    private Long departmentId;

    private String departmentName;

    private Long upperId;
}