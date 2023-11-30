package umc.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springDemo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
