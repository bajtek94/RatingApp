package com.example.ratingapp.service;

import com.example.ratingapp.model.Category;
import com.example.ratingapp.model.Post;
import com.example.ratingapp.model.User;
import com.example.ratingapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bajtek on 27.05.2017.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void save(Post post) {
//        post.setLikes(0);
//        post.setDislikes(0);

        //post.setCategory(post.getCategory());

        postRepository.save(post);
    }
}
