package ru.learnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        AnimalDao animalDao = context.getBean(AnimalDao.class);

//        Animal animal = new Animal();
//         animal.setName("Dog1");
//        animalDao.insert(animal);

        Animal animal1 = animalDao.getById(1);
        log.info(animal1.toString());

        animalDao.update("Cat1", 1);
        Animal animalUpdate = animalDao.getById(1);
        log.info(animalUpdate.toString());

        List<Animal> animalList = animalDao.geAll();
        log.info(animalList.toString());
    }
}