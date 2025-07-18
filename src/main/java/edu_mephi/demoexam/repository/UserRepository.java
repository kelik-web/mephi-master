package edu_mephi.demoexam.repository;

import edu_mephi.demoexam.enums.Country;
import edu_mephi.demoexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Найти всех пользователей, не из указанной страны, отсортированных по возрасту по возрастанию
    List<User> findByCountryNotOrderByAgeAsc(Country country);
}
