package com.example.ratingapp.service;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bajtek on 27.05.2017.
 */
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void save(Post post) {
        post.setLikes(0);
        post.setDislikes(0);
        postRepository.save(post);
    }
}
