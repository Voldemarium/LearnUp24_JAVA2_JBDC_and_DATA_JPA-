package ru.learnUp.dao;

import ru.learnUp.entity.Post;

import java.util.List;

public interface PostDao {
    Post findById(long id);
    List<Post> findAll();
    List<Post> findByText(String text);
    void save(Post post);
    void  deleteById(long id);
}
