package umc.hagosimda.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hagosimda.domain.common.BaseEntity;
import umc.hagosimda.domain.enums.PotType;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Pot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long potId;

    @Column(nullable = false, length = 40)
    private String potTitle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private PotType potType;

    @Column(nullable = false)
    private int progress; //진행도(%)

    private int period; //기간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garden_id")
    private Garden garden;
}
