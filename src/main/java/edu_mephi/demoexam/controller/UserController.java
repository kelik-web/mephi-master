package edu_mephi.demoexam.controller;

import edu_mephi.demoexam.dto.UserCreationDto;
import edu_mephi.demoexam.enums.Country;
import edu_mephi.demoexam.model.User;
import edu_mephi.demoexam.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
@Tag(name = "User API", description = "Операции с пользователями")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить список всех пользователей",
               responses = {@ApiResponse (responseCode = "200", description =  "Список пользователей успешно получен")
    })
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok (users);
    }

    @Operation(summary = "Добавить нового пользователя",
                responses = { @ApiResponse(responseCode = "201", description = "Пользователь успешно создан"),
                        @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserCreationDto dto) {
        User user = new User(null, dto.getFirstName(), dto.getAge(), dto.getCountry());
        User created = userService.addUser(user);
        return ResponseEntity.status(201).body(created);
    }

    @Operation (summary = "Получить список пользователей не из заданной страны",
                responses = {@ApiResponse (responseCode = "200", description = "Пользователи успешно отфильтрованы"),
                            @ApiResponse (responseCode = "400", description = "Некорректное название страны: Invalid_Country")
    })
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
