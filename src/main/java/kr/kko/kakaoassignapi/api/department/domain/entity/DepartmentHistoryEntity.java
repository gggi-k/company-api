package kr.kko.kakaoassignapi.api.department.domain.entity;

import kr.kko.kakaoassignapi.api.department.domain.vo.DepartmentHistoryId;
import kr.kko.kakaoassignapi.core.jpa.entity.BaseEntity;
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
@Table(name = "DEPARTMENT_HISTORY")
public class DepartmentHistoryEntity {

    @EmbeddedId
    private DepartmentHistoryId departmentHistoryId;

    @Comment("부서명")
    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @Comment("상위부서아이디")
    @Column(name = "UPPER_DEPARTMENT_ID")
    private Long upperDepartmentId;

    @Comment("법인아이디")
    @Column(name = "CORPORATION_ID")
    private Long corporationId;
}