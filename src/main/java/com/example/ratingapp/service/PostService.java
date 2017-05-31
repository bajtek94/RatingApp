package com.example.ratingapp.service;

import com.example.ratingapp.model.Post;
import org.springframework.stereotype.Service;

/**
 * Created by Bajtek on 27.05.2017.
 */

public interface PostService {
    void save(Post post);
}
