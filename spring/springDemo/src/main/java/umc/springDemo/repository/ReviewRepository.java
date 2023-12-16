package umc.springDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
    Page<Review> findAllByUser(User user, PageRequest pageRequest);

}
