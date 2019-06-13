package com.serving.qweater.entity;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    private String tags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message(String text, String tags, User author) {
        this.author = author;
        this.text = text;
        this.tags = tags;
    }

    // Нужен конструктор по дефолту, иначе не будет работать эта сущность..
    // Скорее всего идет какое то наследование
    public Message() {}

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<empty>";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
