package ru.learnUp.dao;

import org.springframework.stereotype.Component;
import ru.learnUp.entity.Post;
import ru.learnUp.repository.PostRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringDataPostDao implements PostDao {

    private final PostRepository repository;

    public SpringDataPostDao(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post findById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        Iterable<Post> posts = repository.findAll();
        posts.forEach(postList::add);
        return postList;
    }

    @Override
    public List<Post> findByText(String text) {
        return repository.findByTextContainsOrderByText(text);
    }

    @Override
    public void save(Post post) {
        repository.save(post);
    }

    @Override
    public void deleteById(long id) {
         repository.deleteById(id);
    }
}
