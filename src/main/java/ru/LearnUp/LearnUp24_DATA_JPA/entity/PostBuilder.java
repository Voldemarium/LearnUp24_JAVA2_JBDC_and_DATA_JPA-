package ru.LearnUp.LearnUp24_DATA_JPA.entity;

import java.util.List;

public class PostBuilder {
    private Long id;
    private String title;
    private String text;
    private List<Comment> comments;


    public PostBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public PostBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder withComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Post build() {
        Post post = new Post();
        post.setTitle(title);
        post.setText(text);
        post.setComments(comments);
        return post;
    }
}
