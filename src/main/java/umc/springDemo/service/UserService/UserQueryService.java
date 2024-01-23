package umc.springDemo.service.UserService;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> findUser(Long id);

    Page<Review> getReviewList(Long userId, Integer page);
}
