package umc.hagosimda.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hagosimda.domain.common.BaseEntity;
import umc.hagosimda.domain.enums.TagColor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(nullable = false, length = 40)
    private String todoTitle;

    @Enumerated(EnumType.STRING)
    private TagColor tagColor;

    @Column(nullable = false)
    private boolean isFixed; //달력에 고정 여부

    @Column(nullable = false)
    private boolean isCompleted;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pot_id")
    private Pot pot;
}
