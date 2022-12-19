package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.User;
import be.helb.PierrePlay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("users")
    public List<User> UserList()
    {
        return userService.getAll();
    }

    @GetMapping("users/{username}")
    public User UserGet(@PathVariable String username)
    {
        return userService.getByUsername(username);
    }

    @PostMapping(path="/signup") // Map ONLY POST Requests
    public @ResponseBody String signup(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userService.signUp(user);
        return user.toString();
    }

    @PostMapping(path="/login") // Map ONLY POST Requests
    public @ResponseBody String login(@RequestBody User loginRequestModel) {
        throw new IllegalStateException("There is no login, why are you here");
    }
}
