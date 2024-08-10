package kg.attractor.controlw.service;

import kg.attractor.controlw.dao.UserDao;
import kg.attractor.controlw.dto.UserDto;

public interface UserService {

    void createUser(UserDto userDto);

    void createUser(UserDao userDao);
}
