package com.example.ratingapp.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by Bajtek on 17.05.2017.
 */
@Entity
@Table(name = "post")
public class Post {
    private Long id;
    private String title;
    private String description;
    private int likes;
    private int dislikes;
    @Column(name = "user_id")
    private User user;
//    private Calendar date;
    @Column(name = "category_id")
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
