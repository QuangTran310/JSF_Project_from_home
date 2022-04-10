package com.demo.validation.name;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("nameLengthValidation")
public class NameLengthValidation implements Validator {
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String name = (String) value;
		if (name != null) {
			if (name.length() > 100 || name.length() <= 1) {
				FacesMessage fm = new FacesMessage(
						"Name length must greater than 1 character and smaller than 100 characters.");
				fm.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(fm);
			}
		}
	}
}
