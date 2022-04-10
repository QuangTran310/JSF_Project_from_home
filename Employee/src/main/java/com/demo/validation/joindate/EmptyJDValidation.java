package com.demo.validation.joindate;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("emptyJDValidation")
public class EmptyJDValidation implements Validator {
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Date joinDate = (Date) value;
		if (joinDate == null) {
			FacesMessage fm = new FacesMessage("Join date can not be empty.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fm);
		}
	}
}
