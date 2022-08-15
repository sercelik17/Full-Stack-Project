package yte.intern.data.project.authentication.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.UserRepository;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserTablePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void populateDatabase() {
        if (!userRepository.existsByUsername("user")) {
            Users user = new Users("user", passwordEncoder.encode("user"), List.of(new Authority("USER")));
            userRepository.save(user);
        }
        if (!userRepository.existsByUsername("admin")) {
            Users user = new Users("admin", passwordEncoder.encode("admin"), List.of(new Authority("ADMIN")));
            userRepository.save(user);
        }
    }

}