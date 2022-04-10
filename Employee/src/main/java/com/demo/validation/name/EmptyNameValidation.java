package com.demo.validation.name;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("emptyNameValidation")
public class EmptyNameValidation implements Validator {
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String name = (String) value;
		if (name == null) {
			FacesMessage fm = new FacesMessage("Name can not be empty.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fm);
		}
	}
}
