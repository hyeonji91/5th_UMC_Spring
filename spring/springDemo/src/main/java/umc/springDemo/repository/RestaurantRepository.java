package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.Region;
import umc.springDemo.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
