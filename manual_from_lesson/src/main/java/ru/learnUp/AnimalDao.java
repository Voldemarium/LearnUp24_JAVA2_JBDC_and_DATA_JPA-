package ru.learnUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalDao {
    private final NamedParameterJdbcTemplate jbdc;

    public AnimalDao(NamedParameterJdbcTemplate template) {
        this.jbdc = template;
    }

    public Animal getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jbdc.queryForObject("select * from animal where id=:id", params, new AnimalMapper());
    }

    @Transactional
    public Animal insert(Animal animal) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", animal.getName());
        SqlParameterSource parameterSource = new MapSqlParameterSource(params);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jbdc.update("insert into animal (name) values (:name)", parameterSource, holder);
               System.out.println("holder = " + holder.getKey().longValue());
        animal.setId(holder.getKey().intValue());
        return animal;
    }

    @Transactional
    public int update(String name, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("id", id);
        int n = jbdc.update("update animal set name=:name where id=:id", params);
        return n;
    }

    public List<Animal> geAll() {
        return jbdc.query("select * from animal", new AnimalMapper());
    }
}
