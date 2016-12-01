package com.LabaLaba.validator;

import com.LabaLaba.form.CustomerRegistrationForm;
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
        return aClass.equals(CustomerRegistrationForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerRegistrationForm form = (CustomerRegistrationForm) o;

        if(!form.getPassword().equals(form.getRepeatPassword())) {
            errors.reject("password.not_match", "Password not match");
        }
    }
}
