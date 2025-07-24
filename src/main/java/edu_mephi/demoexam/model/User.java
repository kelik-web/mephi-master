package edu_mephi.demoexam.model;


import edu_mephi.demoexam.enums.Country;
import jakarta.persistence.*;

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


    private String firstName;


    private Integer age;

    @Enumerated(EnumType.STRING)
    private Country country;
}