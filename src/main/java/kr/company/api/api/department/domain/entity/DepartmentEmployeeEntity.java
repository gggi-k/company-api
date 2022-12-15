package kr.company.api.api.department.domain.entity;


import kr.company.api.api.department.domain.code.PositionCode;
import kr.company.api.api.department.domain.vo.DepartmentEmployeeId;
import kr.company.api.core.jpa.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Getter
@ToString
@Entity
@Table(name = "DEPARTMENT_EMPLOYEE")
public class DepartmentEmployeeEntity extends BaseEntity {

    @EmbeddedId
    private DepartmentEmployeeId departmentEmployeeId;

    @Enumerated(EnumType.STRING)
    @Comment("직책코드")
    @Column(name = "POSITION_CODE")
    private PositionCode positionCode;

}