package ru.learnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.dao.PostDao;
import ru.learnUp.dao.SpringDataPostDao;
import ru.learnUp.entity.Post;

import java.util.List;

@SpringBootApplication
@Slf4j
public class Main_2 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main_2.class, args);
        //Spring and Data JPA
        PostDao postDao = context.getBean(SpringDataPostDao.class);
        Post post = postDao.findById(1);
        log.info("post: {}", post);
        List<Post> list = postDao.findAll();
        log.info("list: {}", list);

//        Post post1 = new PostBuilder().withText("Big world!!!").withTitle("World").build();
//        postRepository.save(post1);
        log.info("posts: {}", postDao.findByText("world"));

//        Post post2 = new PostBuilder().withText("Wow").withTitle("Waw").build();
//        Comment comment = new Comment();
//        comment.setText("Wow1");
//        comment.setPost(post2);
//        post2.setComments(List.of(comment));
//
//        postDao.save(post2);
//        log.info("posts: {}", postDao.findAll());


    }

}
