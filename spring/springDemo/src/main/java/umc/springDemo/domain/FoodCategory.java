package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.domain.mapping.UserPrefer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodCategoryId;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

}
