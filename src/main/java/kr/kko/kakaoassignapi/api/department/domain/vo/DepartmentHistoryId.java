package kr.kko.kakaoassignapi.api.department.domain.vo;

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
public class DepartmentHistoryId implements Serializable {

    @Comment("부서아이디")
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Comment("이력일")
    @Column(name = "HISTORY_DATE")
    private LocalDate historyDate;
}