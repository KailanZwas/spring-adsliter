package com.example.springadlistner.controller;


import com.example.springadlistner.models.Ad;
import com.example.springadlistner.models.User;
import com.example.springadlistner.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository usersDao;

    public UserController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        usersDao.save(user);
        return "redirect:/ads";
    }
//    @GetMapping("/user/{id}/ads")
//    public String userAds(@PathVariable long id, Model model){
//        User user = usersDao.findById(id);
//        List<Ad> userAds = user.getAds();
//        Model.addAttribute("userAds", userAds);
//            return "/usersAds";
//    }
@GetMapping("/user/{id}/ads")
public String userAds(@PathVariable long id, Model model){
    User user = usersDao.findById(id);
    List<Ad> userAds = user.getAds();
    model.addAttribute("userAds", userAds);
    return "/ads/userAds";
}
}















