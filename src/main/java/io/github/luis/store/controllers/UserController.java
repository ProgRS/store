package io.github.luis.store.controllers;

import io.github.luis.store.models.User;
import io.github.luis.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String index(Model model){
        return "users/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users/create";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        return "users/edit";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "users/create";
        }

        // Validar se a senha e a confirmação de senha coincidem
        if (!user.getSenha().equals(user.getConfirmarSenha())) {
            model.addAttribute("erroSenha", "A senha e a confirmação de senha não coincidem");
            return "users/create";
        }

        this.userService.create(user);

        return "redirect:/users";
    }
}
