package umc.springDemo.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class RestaurantConverter {
    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getRestaurantId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request) {
        return Restaurant.builder()
                .restaurantName(request.getRestaurantName())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){

        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getReviewBody())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static RestaurantResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return RestaurantResponseDTO.MissionPreViewDTO.builder()
                .dDay(mission.getDDay())
                .amount(mission.getAmount())
                .point(mission.getPoint())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static RestaurantResponseDTO.MissonPreViewListDTO missonPreViewListDTO(Page<Mission> missionList){
        List<RestaurantResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(RestaurantConverter::missionPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.MissonPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }


}
