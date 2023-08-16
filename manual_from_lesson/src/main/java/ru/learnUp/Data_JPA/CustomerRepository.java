package ru.learnUp.Data_JPA;

import org.springframework.data.repository.CrudRepository;
import ru.learnUp.Animal;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findByName(String name);
}
