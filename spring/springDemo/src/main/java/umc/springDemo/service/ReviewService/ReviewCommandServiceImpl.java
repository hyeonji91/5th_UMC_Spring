package umc.springDemo.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.RestaurantHandler;
import umc.springDemo.apiPayload.exception.handler.UserHandler;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.ReviewConverter;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.ReviewImg;
import umc.springDemo.domain.User;
import umc.springDemo.repository.RestaurantRepository;
import umc.springDemo.repository.ReviewRepository;
import umc.springDemo.repository.UserRepository;
import umc.springDemo.web.dto.ReviewRequestDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Review postReview(ReviewRequestDTO.PostReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);

        User user =  userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        newReview.setReview(
                user,
                user.getName(),
                restaurantRepository.findById(request.getRestaurantId())
                        .orElseThrow(()->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND))
        );

        return reviewRepository.save(newReview);
    }
}
