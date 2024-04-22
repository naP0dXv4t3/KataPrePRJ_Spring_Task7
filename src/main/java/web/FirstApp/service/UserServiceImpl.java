package web.FirstApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.FirstApp.dao.UserDao;
import web.FirstApp.model.User;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
}
