package edu_mephi.demoexam.dto;

import edu_mephi.demoexam.enums.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UserCreationDto {

    @NotBlank (message = "Поле Имя обязательно для заполнения")
    private String firstName;

    @NotNull (message = "Поле возраст обязательно для заполнения")
    @Min(value = 0, message = "возраст не может быть отрицательным")
    private Integer age;

    @NotNull(message = "Поле страна обязательно для заполнения")
    private Country country;
}
