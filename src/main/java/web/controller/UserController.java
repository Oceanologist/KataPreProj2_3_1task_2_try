package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private User user;

    @Autowired  // Добавлена аннотация
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String viewAllUsers(Model model) {
        model.addAttribute("users", userService.viewAllUsers());
        return "allUsers";
    }

    @GetMapping("/new")
    public String showFormAddUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        this.user = user;  // Убрано ("user"), т.к. имя совпадает
        userService.add(user);
        return "redirect:/users";
    }
}