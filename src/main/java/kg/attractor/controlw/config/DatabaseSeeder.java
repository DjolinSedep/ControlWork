package kg.attractor.controlw.config;

import kg.attractor.controlw.model.User;
import kg.attractor.controlw.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Bean
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("12345")) {
                User admin = User.builder()
                        .username("12345")
                        .email("admin@example.com")
                        .password(passwordEncoder.encode("qwerty"))
                        .isAdmin(true)
                        .build();
                userRepository.save(admin);
            }
        };
    }
}
