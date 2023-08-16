package ru.learnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.dao.NamedParametersJDBCTemplatePostDao;
import ru.learnUp.entity.Post;

import java.util.List;

@SpringBootApplication
@Slf4j
public class LearnUp24DataJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LearnUp24DataJpaApplication.class, args);
		NamedParametersJDBCTemplatePostDao dao = context.getBean(NamedParametersJDBCTemplatePostDao.class);
		Post post = dao.findById(1);
		log.info("post: {}", post);
        List<Post> posts = dao.findAll();
        log.info("posts: {}", posts);

    }

}
