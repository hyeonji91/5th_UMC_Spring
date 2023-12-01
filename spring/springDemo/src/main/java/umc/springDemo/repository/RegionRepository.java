package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.FoodCategory;
import umc.springDemo.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
