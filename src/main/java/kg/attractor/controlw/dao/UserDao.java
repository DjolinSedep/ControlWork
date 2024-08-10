package kg.attractor.controlw.dao;
import kg.attractor.controlw.dto.UserDto;
import kg.attractor.controlw.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate template;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(User user) {
        String sql = "INSERT INTO USERS (username, email, password, enabled, AUTHORITY_ID) VALUES " +
                "(:username, :email, :password, :enabled, :authorityId)";
        namedParameterJdbcTemplate.update(
                sql,
                new MapSqlParameterSource()
                        .addValue("username", user.getUsername())
                        .addValue("email", user.getEmail())
                        .addValue("password", user.getPassword())
                        .addValue("enabled", true)
                        .addValue("authorityId", 1)
        );
    }

    public List<    UserDto> getAllUsers() {
        String sql = "select * from users";
        return template.query(sql, new BeanPropertyRowMapper<>(UserDto.class));
    }

    public Optional<UserDto> getUserById(Long id) {
        String sql = "select * from users where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(template.query(sql, new BeanPropertyRowMapper<>(UserDto.class), id))
        );
    }

    public Optional<UserDto> getUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(template.query(sql, new BeanPropertyRowMapper<>(UserDto.class), email))
        );
    }
}