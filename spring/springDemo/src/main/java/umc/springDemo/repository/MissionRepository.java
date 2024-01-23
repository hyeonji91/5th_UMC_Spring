package umc.springDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;

import java.util.Optional;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

}
