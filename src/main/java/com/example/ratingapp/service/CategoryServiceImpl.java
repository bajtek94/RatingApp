package com.example.ratingapp.service;

import com.example.ratingapp.model.Category;
import com.example.ratingapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bajtek on 30.05.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {

    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findById(String  id) {
        return categoryRepository.findOne(Long.parseLong(id));
    }

    @Override
    public List<Category> getListOfCategory() {
        return categoryRepository.findAll();
    }
}
