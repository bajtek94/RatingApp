package com.example.ratingapp.validator;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Bajtek on 27.05.2017.
 */
@Component
public class PostValidator implements Validator {

//    @Autowired
//    private PostService postService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;


    }
}