package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;

import javax.persistence.*;

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

    @Column(nullable = false, length = 45)
    private String restaurantCategory;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
