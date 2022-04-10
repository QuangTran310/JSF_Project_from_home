package com.demo.validation.phonenumber;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("emptyPhoneNumberValidation")
public class EmptyPhoneNumberValidation implements Validator {
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String phoneNumber = (String) value;
		if (phoneNumber == null) {
			FacesMessage fm = new FacesMessage("Phone number can not be empty.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fm);
		}
	}
}
