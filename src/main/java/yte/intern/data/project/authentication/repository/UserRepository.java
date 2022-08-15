package yte.intern.data.project.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);
}
