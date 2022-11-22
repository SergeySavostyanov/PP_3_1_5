package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Person;
import ru.kata.spring.boot_security.demo.services.AdminService;
import ru.kata.spring.boot_security.demo.services.PersonServiceImpl;
import ru.kata.spring.boot_security.demo.services.RegistrationService;
import ru.kata.spring.boot_security.demo.util.PersonValidator;

import javax.validation.Valid;

@RequestMapping("/admin")
@Controller
public class AdminController {
    private final PersonServiceImpl personService;
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    private final AdminService adminService;

    public AdminController(PersonServiceImpl personService, PersonValidator personValidator, RegistrationService registrationService, AdminService adminService) {
        this.personService = personService;
        this.personValidator = personValidator;
        this.registrationService = registrationService;
        this.adminService = adminService;
    }



    @GetMapping(value = "/add")
    public String greetingForm(Model model) {
        model.addAttribute("person", new Person());
        return "/admin/add";
    }

    @PostMapping(value = "/add")
    public String greetingSubmit(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        registrationService.register(person);
        return "/admin/result";
    }


    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Long id, Person person, Model model) {

        adminService.doAdminStuff();
        model.addAttribute("person", person);
        personService.removeUser(id);
        return "redirect:/admin";
    }

}
