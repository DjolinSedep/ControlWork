package kg.attractor.controlw.service.impl;
import kg.attractor.controlw.dao.UserDao;
import kg.attractor.controlw.dto.UserDto;
import kg.attractor.controlw.repository.UserRepository;
import kg.attractor.controlw.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {

    }

    @Override
    public void createUser(UserDao userDao) {

    }
}