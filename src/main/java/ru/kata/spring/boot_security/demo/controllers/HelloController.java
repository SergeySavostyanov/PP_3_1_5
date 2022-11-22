package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.Person;
import ru.kata.spring.boot_security.demo.services.AdminService;
import ru.kata.spring.boot_security.demo.services.PersonService;

@Controller
public class HelloController {
    private final PersonService personService;
    private final AdminService adminService;

    public HelloController(PersonService personService, AdminService adminService) {
        this.personService = personService;
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPageP(Model model){
        adminService.doAdminStuff();
        model.addAttribute("listUsers", personService.listUsers());
        return "admin";
    }

    @GetMapping("/user-update/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        adminService.doAdminStuff();
        Person person = personService.getById(id);
        model.addAttribute("person", person);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String editUser(Person person) {
        adminService.doAdminStuff();
        personService.saveUser(person);
        return "redirect:/admin";
    }
    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Long id, Person person, Model model) {
        adminService.doAdminStuff();
        model.addAttribute("person", person);
        personService.removeUser(id);
        return "redirect:/admin";
    }


}
