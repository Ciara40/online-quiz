package repository;

import domain.User;

import java.util.List;

/**
 * Created by usha on 4/7/2017.
 */
public interface UserRepository {
    User findUser(String name, String password);
    List<User> findAll();
    Integer save(User user);
    void delete(int id);
    int update(User user);
    User findUserById(int id);
}
