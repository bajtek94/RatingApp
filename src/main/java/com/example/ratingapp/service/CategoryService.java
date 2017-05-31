package com.example.ratingapp.service;

import com.example.ratingapp.model.Category;

import java.util.List;

/**
 * Created by Bajtek on 30.05.2017.
 */
public interface CategoryService {
    void save(Category category);
    Category findByName(String name);
    List<Category> getListOfCategory();
    Category findById(String id);
}
