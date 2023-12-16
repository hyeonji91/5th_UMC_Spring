package umc.springDemo.converter;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;
import umc.springDemo.domain.enums.Gender;
import umc.springDemo.web.dto.UserRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public static UserResponseDTO.JoinReslutDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinReslutDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .userPreferList(new ArrayList<>())
                .build();

    }

    public static UserResponseDTO.GetMyReviewDTO getMyReviewDTO(Review review){
        return UserResponseDTO.GetMyReviewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getReviewBody())
                .reviewImg(review.getReviewImgList())
                .build();
    }
    public static UserResponseDTO.GetMyReviewListDTO getMyReviewListDTO(Page<Review> reviewList){
        List<UserResponseDTO.GetMyReviewDTO> myReviewDTOList = reviewList.stream()
                .map(UserConverter::getMyReviewDTO).collect(Collectors.toList());
        return UserResponseDTO.GetMyReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(myReviewDTOList.size())
                .myReviewList(myReviewDTOList)
                .build();
    }
}
