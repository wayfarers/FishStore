package org.genia.fishstore.web.converters;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.dao.FishTypeDaoImpl;
import org.genia.fishstore.entities.FishType;
import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class FishTypeConverter implements Converter {

    @Inject
    private FishTypeDaoImpl dao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return dao.findById(Integer.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid FishType ID", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof FishType) {
            return String.valueOf(((FishType) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", modelValue)));
        }
    }

}