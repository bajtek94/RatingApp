package com.example.ratingapp.model;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

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
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "img")
    private byte[] img;
//    private Calendar date;
    @SuppressWarnings("unused")
    private String base64;

    @Transient
    public String getBase64() {
        this.base64 = Base64.encode(this.img);
        return this.base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
