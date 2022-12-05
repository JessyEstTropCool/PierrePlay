package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.UserDao;
import be.helb.PierrePlay.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserDao userDao;

    @GetMapping("users")
    public List<User> UserList()
    {
        return userDao.findAll();
    }
}