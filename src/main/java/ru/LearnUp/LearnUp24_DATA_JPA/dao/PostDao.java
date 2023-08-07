package ru.LearnUp.LearnUp24_DATA_JPA.dao;

import ru.LearnUp.LearnUp24_DATA_JPA.entity.Post;

import java.util.List;

public interface PostDao {
    Post findById(long id);
    List<Post> findAll();
    void save(Post post);
    void  deleteById(long id);
}
