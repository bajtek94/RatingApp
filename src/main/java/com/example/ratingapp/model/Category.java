package com.example.ratingapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bajtek on 17.05.2017.
 */

@Entity
@Table(name = "category")
public class Category {
    private Long id;
    private String name;
    private String description;
    private Set<Post> posts;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
