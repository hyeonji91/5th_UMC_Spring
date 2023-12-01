package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;

import java.util.Optional;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Optional<UserMission> findMssionByMission_MissionIdAndUser_UserId(Long missionId, Long userId);
}
