package com.example.ratingapp.validator;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        if(post.getTitle().length() < 3 || post.getTitle().length() > 40) {
            errors.rejectValue("title", "Post.title.size");
        }
        if(post.getDescription().length() < 3 || post.getDescription().length() > 120) {
            errors.rejectValue("description", "Post.title.size");
        }
    }
}
