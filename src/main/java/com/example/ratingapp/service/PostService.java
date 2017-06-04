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

}
