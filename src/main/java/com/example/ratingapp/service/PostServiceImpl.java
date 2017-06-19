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

import java.util.ArrayList;
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

    @Override
    public Post findById(String id) {
        return postRepository.findOne(Long.parseLong(id));
    }

    @Override
    public void addLike(Post post) {
        Post tmp = postRepository.findOne(post.getId());
        tmp.setLikes(post.getLikes() + 1);
        postRepository.save(tmp);
    }

    @Override
    public void addDislike(Post post) {
        Post tmp = postRepository.findOne(post.getId());
        tmp.setDislikes(post.getDislikes() + 1);
        postRepository.save(tmp);
    }

    @Override
    public List<Post> findByText(String searchText) {
        List<Post> list = new ArrayList<>();
        List<Post> tmp = new ArrayList<>();
        tmp = postRepository.findByTitle(searchText);
        for (Post p: tmp) {
            list.add(p);
        }
        return list;
    }

    @Override
    public List<Post> findByTitle(String searchText) {
        return postRepository.findByTitle(searchText);
    }

    @Override
    public List<Post> findByDescription(String searchText) {
        return postRepository.findByDescription(searchText);
    }

    @Override
    public void deletePostById(String id) {
        Post post = postRepository.findOne(Long.parseLong(id));
        if(post != null) {
            postRepository.delete(post.getId());
        }
    }

    @Override
    public void updatePost(Post post) {
        Post postTmp = postRepository.findOne(post.getId());
        if(postTmp != null) {
            postTmp.setTitle(post.getTitle());
            postTmp.setDescription(post.getDescription());
        }
        postRepository.save(postTmp);
    }
}
