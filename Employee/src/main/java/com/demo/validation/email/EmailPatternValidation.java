package com.demo.validation.email;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("emailPatternValidation")
public class EmailPatternValidation implements Validator {

	String regex = "^(.+)@(.+)$";

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String) value;
		if (email != null) {
			if (!Pattern.matches(regex, email)) {
				FacesMessage fm = new FacesMessage("Invalid email.");
				fm.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(fm);
			}
		}
	}

}
