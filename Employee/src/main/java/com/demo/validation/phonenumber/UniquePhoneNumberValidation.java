package com.demo.validation.phonenumber;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.EmployeeDAO;

public class UniquePhoneNumberValidation implements ConstraintValidator<UniquePhoneNumber, String> {
	@Inject
	EmployeeDAO employeeDAO;

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		return employeeDAO.isPhoneNumberExists(phoneNumber) == true ? false : true;
	}
}
