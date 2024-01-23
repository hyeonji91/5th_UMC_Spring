package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false, length = 256)
    private String reviewBody;

    private Float score;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImg> reviewImgList = new ArrayList<>();

    public void setReview(User user, String name, Restaurant restaurant){
        this.user = user;
        this.restaurant = restaurant;
    }
}
