package com.LabaLaba.validator;

import com.LabaLaba.model.UserRegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by rien on 11/28/16.
 */
@Component
public class UserRegistrationFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserRegistrationForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;

        if(!form.getPassword().equals(form.getRepeatPassword())) {
            errors.reject("password.not_match", "Password not match");
        }
    }
}
