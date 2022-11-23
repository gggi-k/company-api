package kr.kko.kakaoassignapi.api.corporation.domain;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@FieldNameConstants
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "CORPORATION", uniqueConstraints = @UniqueConstraint(columnNames = "CORPORATION_NAME"))
public class CorporationEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Comment("법인아이디")
    @Column(name = "CORPORATION_ID")
    private Long corporationId;

    @Comment("법인명")
    @Column(name = "CORPORATION_NAME", nullable = false)
    private String corporationName;
}