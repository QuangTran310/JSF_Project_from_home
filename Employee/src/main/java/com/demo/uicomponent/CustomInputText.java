package com.demo.uicomponent;

import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.convert.Converter;

import com.demo.converter.InputDateConverter;

@FacesComponent(createTag = true, tagName = "inputDate", namespace = "http://customUIComponent.com/inputDate", value = "com.demo.uicomponent")
public class CustomInputText extends HtmlInputText {
	
	@SuppressWarnings("rawtypes")
	@Override
	public Converter getConverter() { // TODO Auto-generated method
		return new InputDateConverter();
		//return new ExtendedDateTimeConverter();
	}
}
