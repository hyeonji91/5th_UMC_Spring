package umc.springDemo.domain;

import lombok.*;
import umc.springDemo.domain.common.BaseEntity;
import umc.springDemo.domain.enums.Gender;
import umc.springDemo.domain.enums.UserStatus;
import umc.springDemo.domain.mapping.UserPrefer;
import umc.springDemo.domain.mapping.UserMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)")
    private Gender gender;

    private LocalDate birth;

    @Column(length = 30)
    private String address;

    @Column(nullable = false, length = 45)
    private String name;

    //@Column(nullable = false, length = 45)
    private String eMail;

    @Column(length = 15)
    private String phoneNumber;

    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'active'")
    private UserStatus status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}
