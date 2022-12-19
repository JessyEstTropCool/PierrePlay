package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.UserDao;
import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getByUsername(String username) { return userDao.findByUsername(username); }

    public List<User> getAll() { return userDao.findAll(); }

    public void signUp(User user) { userDao.save(user); }

    public UserDao getUserDao() { return userDao; }

    public void setUserDao(UserDao userDao) { this.userDao = userDao; }
}
