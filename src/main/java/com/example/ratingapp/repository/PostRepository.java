package com.example.ratingapp.repository;

import com.example.ratingapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Bajtek on 17.05.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title") String title);

    @Query("SELECT p FROM Post p WHERE p.description = :description")
    List<Post> findByDescription(@Param("description") String description);


}
