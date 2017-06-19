package com.example.ratingapp.service;

import com.example.ratingapp.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bajtek on 27.05.2017.
 */

public interface PostService {
    void save(Post post);
    List<Post> getPostList();
    Page<Post> getPostLog(Integer pageNumber);
    Post findById(String id);
    void addLike(Post post);
    void addDislike(Post post);
    List<Post> findByText(String searchText);
    List<Post> findByTitle(String searchText);
    List<Post> findByDescription(String searchText);
    void deletePostById(String id);
    void updatePost(Post postForm);
}
