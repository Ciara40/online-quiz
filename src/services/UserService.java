package services;

import domain.User;

import java.util.List;

/**
 * Created by usha on 4/7/2017.
 */
public interface UserService {
    User getUser(String name, String password);
    List<User> getUserList();
    Integer save(User user);
    void deleteUser(int id);
    int update(User user);
    User getUserById(int id);
}
