package de.cyber_simon.zeptor.util;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import de.cyber_simon.zeptor.entity.BaseEntity;
import de.cyber_simon.zeptor.service.BaseService;

public class EntityConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	private BaseService<? extends BaseEntity> service;

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value)
			throws ConverterException {
        if (value == null || value.length() == 0) {
            return null;
        }
        Long id = new Long(value);
		return service.findById(id);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value)
			throws ConverterException {
        if (value == null) {
            return "";
        }
        return ((BaseEntity)value).getId().toString();
	}

    // Dependency injection setter
    public void setService(BaseService<? extends BaseEntity> service) {
        this.service = service;
    }

}
