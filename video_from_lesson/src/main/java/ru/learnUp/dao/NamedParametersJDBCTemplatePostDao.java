package ru.learnUp.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnUp.entity.Comment;
import ru.learnUp.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class NamedParametersJDBCTemplatePostDao implements PostDao {

    private final NamedParameterJdbcTemplate template;

    public NamedParametersJDBCTemplatePostDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Post findById(long id) {
        return template.query(
                "SELECT p.id as post_id, p.text as post_text, title, " +
                        " c.id as comment_id, c.text as comment_text " +
                        " FROM post p join \"comment\" c on p.id = c.post_id WHERE p.id=1",
                new MapSqlParameterSource("postId", id),
                rs -> {
                    Post post = new Post();
                    post.setComments(new ArrayList<>());
                     while (rs.next()) {
                         post.setId(rs.getLong("post_id"));
                         post.setText(rs.getString("post_text"));
                         post.setTitle(rs.getString("title"));
                         Comment comment = new Comment();
                         comment.setId(rs.getLong("comment_id"));
                         comment.setText(rs.getString("comment_text"));
                         post.getComments().add(comment);
                     }
                     return post;
                }
        );
    }

    @Override
    public List<Post> findAll() {
        return template.query(
                "SELECT p.id as post_id, p.text as post_text, title, " +
                        " c.id as comment_id, c.text as comment_text " +
                        " FROM post p join \"comment\" c on p.id = c.post_id WHERE p.id=c.post_id",
                rs -> {
                    Map<Long, Post> postMap = new HashMap<>();

                    while (rs.next()) {
                        Long id = rs.getLong("post_id");
                        if (postMap.containsKey(id)) {          //  значит в postMap уже лежит такой post
                            Post post = postMap.get(id);

                            Comment comment = new Comment();
                            comment.setId(rs.getLong("comment_id"));
                            comment.setText(rs.getString("comment_text"));

                            post.getComments().add(comment);     // добавляем в post только комментарии
                        } else {                                 //  если в postMap нет post с таким id
                            Post post = new Post();
                            post.setComments(new ArrayList<>());

                            post.setId(rs.getLong("post_id"));
                            post.setText(rs.getString("post_text"));
                            post.setTitle(rs.getString("title"));

                            Comment comment = new Comment();
                            comment.setId(rs.getLong("comment_id"));
                            comment.setText(rs.getString("comment_text"));
                            post.getComments().add(comment);

                            postMap.put(id, post);              // кладем в postMap post с его id
                        }
                    }
                    return new ArrayList<>(postMap.values());
                }
        );
    }

    @Override
    public List<Post> findByText(String text) {
        return null;
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void deleteById(long id) {

    }
}
