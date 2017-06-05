package com.example.ratingapp.service;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.model.User;
import com.example.ratingapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bajtek on 27.05.2017.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {
    private static final int PAGE_SIZE = 3;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    @Override
    public void save(Post post) {
//        post.setLikes(0);
//        post.setDislikes(0);

        //post.setCategory(post.getCategory());

        postRepository.save(post);
    }

    @Override
    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getPostLog(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return postRepository.findAll(request);
    }
}
