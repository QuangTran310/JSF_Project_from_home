package com.demo.validation.joindate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("jdPatternValidation")
public class JDPatternValidation implements Validator {
	String regex = "^(0[1-9]|[12][0-9]|[3][01])(0[1-9]|1[012])\\d{4}$";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Map<String, Object> attributes = component.getAttributes();
		String formatString = (String) attributes.get("inputPattern");
		Date jd = (Date) value;
		if (jd != null) {
			DateFormat originalFormat = new SimpleDateFormat(formatString);
			String formattedDate = originalFormat.format(jd);
			if (!Pattern.matches(regex, formattedDate)) {
				FacesMessage fm = new FacesMessage("Format required: ddMMyyyy.");
				fm.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(fm);
			}
		}

	}
}
