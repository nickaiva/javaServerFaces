package tuhra.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.jbo.domain.ClobDomain;

public class ClobConverter implements javax.faces.convert.Converter{
    
    public ClobConverter() {
        super();
    }

    public Object getAsObject(FacesContext facesContext,
                              UIComponent uiComponent, String string) {
        return new ClobDomain(string);
    }

    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object object) {
        return ((ClobDomain)object).toString();
    }
}
