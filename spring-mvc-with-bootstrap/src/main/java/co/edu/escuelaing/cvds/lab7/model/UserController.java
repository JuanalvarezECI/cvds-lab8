package co.edu.escuelaing.cvds.lab7.model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userList.add(user);
        return "redirect:/users/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        User user = findUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "update";
        }
        return "redirect:/users/index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute User updatedUser) {
        User user = findUserById(id);
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
        }
        return "redirect:/users/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = findUserById(id);
        if (user != null) {
            userList.remove(user);
        }
        return "redirect:/users/index";
    }

    private User findUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
