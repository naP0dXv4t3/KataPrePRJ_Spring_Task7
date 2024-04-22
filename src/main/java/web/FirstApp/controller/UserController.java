package web.FirstApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.FirstApp.model.User;
import web.FirstApp.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
   private UserService userService;

   @Autowired
   public UserController(UserService userService){
       this.userService=userService;
   }

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        List<User> allUsers = userService.listUsers();
        model.addAttribute("usersList", allUsers);
        return "index";
    }
    @GetMapping(value = "/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "CreateUser";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.findById(id);
        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "EditUser";
        }
        return "/";
    }

    @PatchMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}