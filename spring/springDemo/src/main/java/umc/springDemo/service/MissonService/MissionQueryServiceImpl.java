package umc.springDemo.service.MissonService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;
import umc.springDemo.domain.enums.MissionType;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.repository.MissionRepository;
import umc.springDemo.repository.ReviewRepository;
import umc.springDemo.repository.UserMissionRepository;
import umc.springDemo.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    public UserMissionRepository userMissionRepository;
    public UserRepository userRepository;
    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }


}
