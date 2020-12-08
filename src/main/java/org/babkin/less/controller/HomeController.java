package org.babkin.less.controller;

import org.babkin.less.dao.UserDAO;
import org.babkin.less.entity.User;
import org.babkin.less.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class HomeController {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/")
    public String hello(){

        return "hello";
    }
    @RequestMapping(value = "/users")
    public String getUsers(Model model) throws SQLException {
        model.addAttribute( "users", userDAO.getAll() );
        return "users";
    }
    @GetMapping(value = "/addUsers")
    public String getSignUp(Model model)
    {
        model.addAttribute( "user", new User(  ) );
        return "sign_up";
    }
    @PostMapping(value = "/addUsers")
    public String getSignUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {
        userValidator.validate( user,  result);
        if (result.hasErrors()){
            return "sign_up";
        }
        userDAO.add(user);
        return "redirect:/users";
    }
}

