package edu_mephi.demoexam.model;


import edu_mephi.demoexam.enums.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Поле Имя обязателньо для заполнения")
    private String firstName;

    @NotNull
    @Min(value = 0, message = "возраст не может быть отрицательным")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Поле страна обязательно для заполнения")
    private Country country;
}