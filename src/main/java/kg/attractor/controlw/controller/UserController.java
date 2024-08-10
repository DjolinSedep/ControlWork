package kg.attractor.controlw.controller;

import kg.attractor.controlw.dto.RegisterDto;
import kg.attractor.controlw.model.User;
import kg.attractor.controlw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerRequest) {

        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return new ResponseEntity<>("Имя пользователя уже занято", HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getPhoneNumber() + "@example.com")
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .isAdmin(false)
                .build();
        userRepository.save(user);

        return new ResponseEntity<>("Пользователь зарегистрирован", HttpStatus.CREATED);
    }
}
