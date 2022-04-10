package com.demo.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@SuppressWarnings("rawtypes")
@FacesConverter(value = "inputDateConverter")
public class InputDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		System.out.println("getAsObject");

		Map<String, Object> attributes = component.getAttributes();
		String formatString = (String) attributes.get("inputPattern");
		System.out.println("inputPattern: " + formatString);
		// System.out.println("input:" + formatString);
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		Date dateVal1 = null;
		if (value != null && value.contains("-")) {
			FacesMessage fm = new FacesMessage("format required: daymonthyear.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(fm);
		}
		try {
			dateVal1 = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			FacesMessage fm = new FacesMessage("format required: daymonthyear.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(fm);
		} catch (NullPointerException e) {
			FacesMessage fm = new FacesMessage("This field is required.");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(fm);
		}
		return dateVal1;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		System.out.println("getAsString");
		Map<String, Object> attributes = component.getAttributes();
		String formatString = (String) attributes.get("outputPattern");
		System.out.println("outputPattern: " + formatString);
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		String formatterdDate = null;
		formatterdDate = sdf.format((java.util.Date) value);
		Date dateVal = null;
		try {
			dateVal = sdf.parse(formatterdDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(dateVal);
	}
}
