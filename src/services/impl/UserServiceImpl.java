package services.impl;

import domain.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import services.UserService;

import java.util.List;

/**
 * Created by usha on 4/3/2017.
 */
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    public User getUser(String name, String password) {

        return userRepository.findUser(name, password);
    }

    public List<User> getUserList() {
        return this.userRepository.findAll();
    }

    public Integer save(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(int id) {
        this.userRepository.delete(id);
    }

    public int update(User user) {
        return this.userRepository.update(user);
    }

    public User getUserById(int id) {
        return this.userRepository.findUserById(id);
    }
}
