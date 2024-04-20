package web.FirstApp.service;

import web.FirstApp.model.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    Optional<User> findById(Long id);

}
