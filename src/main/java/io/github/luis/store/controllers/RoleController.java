package io.github.luis.store.controllers;


import io.github.luis.store.models.Role;
import io.github.luis.store.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public String index(Model model){

        return "roles/index";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("new",new Role());
        return "roles/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/roles/new";
        }
        Role roleCreated = this.roleService.create(role);
        return  "redirect:/roles";
    }
    @DeleteMapping
    public String delete(Model model){
        return  null;
    }


}
