package kr.kko.kakaoassignapi.core.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CreatedEntity {

    @CreatedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Comment("등록일시")
    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Comment("등록자")
    @Column(name = "CREATED_BY", updatable = false, nullable = false)
    private String createdBy;
}