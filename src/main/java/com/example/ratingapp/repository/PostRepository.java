package com.example.ratingapp.repository;

import com.example.ratingapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bajtek on 17.05.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
