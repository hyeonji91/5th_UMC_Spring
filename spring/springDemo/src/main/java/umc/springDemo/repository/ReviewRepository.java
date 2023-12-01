package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
