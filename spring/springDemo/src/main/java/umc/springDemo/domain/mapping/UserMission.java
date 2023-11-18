package umc.springDemo.domain.mapping;

import lombok.*;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.User;
import umc.springDemo.domain.common.BaseEntity;
import umc.springDemo.domain.enums.MissionType;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer identifyNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)")
    private MissionType missionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "mission_id")
    private Mission mission;
}
