package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;
import umc.springDemo.domain.mapping.UserMission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Column(nullable = false, length = 45)
    private String restaurantName;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public void setRegion(Region region){
        this.region = region;
    }
}
