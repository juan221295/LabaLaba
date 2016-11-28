package com.LabaLaba.validator;

import com.LabaLaba.form.SupplierRegistrationForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by rien on 11/29/16.
 */
public class SupplierRegistrationFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SupplierRegistrationForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SupplierRegistrationForm form = (SupplierRegistrationForm)o;

        if(!form.getPassword().equals(form.getRepeatPassword())) {
            errors.reject("password.not_match", "Password not match");
        }
    }
}
