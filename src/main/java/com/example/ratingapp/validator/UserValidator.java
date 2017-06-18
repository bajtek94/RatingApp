package com.example.ratingapp.validator;

import com.example.ratingapp.model.User;
import com.example.ratingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) { // jest w bazie
            if(user.getId() != null) {
                if (userService.findById(user.getId().toString()).getUsername().equals(user.getUsername())) {

                } else {
                    errors.rejectValue("username", "Duplicate.userForm.username");
                }
            }
            else {
                errors.rejectValue("username", "Duplicate.userForm.username");
            }
        }

        if(user.getPassword() != null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.userForm.password");
            }

            if (!user.getPasswordConfirm().equals(user.getPassword())) {
                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            }
        }

        if (user.getName().length() < 3 || user.getName().length() > 20) {
            errors.rejectValue("name", "Register.name.size");
        }
        if (user.getLastName().length() < 3 || user.getLastName().length() > 30) {
            errors.rejectValue("lastName", "Register.lastName.size");
        }



    }

}
