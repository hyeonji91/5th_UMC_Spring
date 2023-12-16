package umc.springDemo.service.MissonService;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;

import java.util.Optional;

public interface MissionQueryService {
    public Optional<User> findUser(Long id);
}
