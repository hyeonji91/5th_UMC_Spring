package umc.hagosimda.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hagosimda.domain.common.BaseEntity;
import umc.hagosimda.domain.enums.GardenCategory;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Garden extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gardenId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "NOTNULL")
    private GardenCategory category;

    @Column(nullable = false, length = 40)
    private String gardenTitle;

    @Column(length = 400)
    private String gardenInfo;

    @Column(nullable = false, length = 40)
    private String calendarTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
