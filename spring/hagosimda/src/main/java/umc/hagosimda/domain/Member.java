package umc.hagosimda.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import umc.hagosimda.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 40)
    private String nickName;

    @Column(nullable = false, length = 40)
    private String phoneNum;

    @Column(nullable = false, length = 40)
    private String eMail;

    @Column(nullable = false, length = 40)
    private String password;

    private String profileImg;
}
