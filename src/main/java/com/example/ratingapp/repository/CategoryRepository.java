package com.example.ratingapp.repository;

import com.example.ratingapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bajtek on 17.05.2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
