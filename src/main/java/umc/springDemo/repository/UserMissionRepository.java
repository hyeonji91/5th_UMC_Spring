package umc.springDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.User;
import umc.springDemo.domain.enums.MissionType;
import umc.springDemo.domain.mapping.UserMission;

import java.util.Optional;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Optional<UserMission> findMissionByMission_MissionIdAndUser_UserId(Long missionId, Long userId);

    Page<UserMission> findAllByUserAndMissionType(User user, MissionType missionType , PageRequest pageRequest);
}
