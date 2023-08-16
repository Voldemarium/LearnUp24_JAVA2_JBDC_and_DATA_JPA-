package ru.learnUp.dao;

import ru.learnUp.entity.Post;

import java.util.List;

public interface PostDao {
    Post findById(long id);
    List<Post> findAll();
    void save(Post post);
    void  deleteById(long id);
}
