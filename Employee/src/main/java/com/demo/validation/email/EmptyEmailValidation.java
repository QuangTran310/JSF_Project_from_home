package com.demo.validation.email;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("emptyEmailValidation")
public class EmptyEmailValidation implements Validator {
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String) value;
		if (email == null) {
			FacesMessage fm = new FacesMessage("Email can not be empty.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fm);
		}
	}
}
