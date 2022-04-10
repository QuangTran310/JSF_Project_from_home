package com.demo.validation.email;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.EmployeeDAO;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {
	
	@Inject
	EmployeeDAO employeeDAO; 
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return employeeDAO.isEmailExists(email) == true ? false : true;
	}
}