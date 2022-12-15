package kr.company.api.api.corporation.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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