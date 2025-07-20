package edu_mephi.demoexam.service;

import edu_mephi.demoexam.enums.Country;
import edu_mephi.demoexam.model.User;
import edu_mephi.demoexam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersNotFromCountry(Country country) {
        return userRepository.findByCountryNotOrderByAgeAsc(country);
    }

}