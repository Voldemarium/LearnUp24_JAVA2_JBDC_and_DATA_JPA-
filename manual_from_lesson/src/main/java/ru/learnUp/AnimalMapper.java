package ru.learnUp;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AnimalMapper implements RowMapper<Animal> {
    // Этот класс преобразует результат запроса к БД ResultSet в объект Animal
    @Override
    public Animal mapRow (ResultSet resultSet, int i) throws SQLException {
        final Integer id = resultSet.getInt("id");
        final String name = resultSet.getString("name");
        return new Animal(id, name);
    }
}
