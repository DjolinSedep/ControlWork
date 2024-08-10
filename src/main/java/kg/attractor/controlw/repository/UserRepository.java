package kg.attractor.controlw.repository;

import kg.attractor.controlw.model.Account;
import kg.attractor.controlw.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends  JpaRepository <Account, Long>{
    public boolean existsByUsername(String username) {
        return false;

    }

    public void save(User user1) {

    }

    public Optional<Object> findById(Long userId) {
        return null;
    }
}
