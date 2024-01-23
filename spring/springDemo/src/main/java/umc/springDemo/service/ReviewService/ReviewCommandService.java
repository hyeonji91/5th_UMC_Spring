package umc.springDemo.service.ReviewService;

import umc.springDemo.domain.Review;
import umc.springDemo.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review postReview(ReviewRequestDTO.PostReviewDTO request);
}
