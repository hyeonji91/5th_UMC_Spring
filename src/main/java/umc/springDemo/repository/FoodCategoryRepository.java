package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
