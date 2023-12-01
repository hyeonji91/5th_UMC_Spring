package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import umc.springDemo.domain.Mission;

import java.util.Optional;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
