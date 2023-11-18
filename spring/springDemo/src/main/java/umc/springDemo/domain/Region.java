package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(nullable = false, length = 45)
    private String region;
}
