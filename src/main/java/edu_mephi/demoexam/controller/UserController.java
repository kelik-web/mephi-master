package edu_mephi.demoexam.controller;

import edu_mephi.demoexam.enums.Country;
import edu_mephi.demoexam.model.User;
import edu_mephi.demoexam.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok (users);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User created = userService.addUser(user);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/additional-info")
    public ResponseEntity<?> getUsersNotFromCountry(@RequestParam String country) {
        try {
            Country countryEnum = Country.valueOf(country.toUpperCase());
            List<User> result = userService.getUsersNotFromCountry(countryEnum);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Некорректное название страны:" + country);
        }
    }
}
