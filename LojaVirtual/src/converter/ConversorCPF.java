package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConversorCPF implements Converter{
	
	public Object getAsObject (FacesContext fc, UIComponent c, String valor) throws ConverterException{
		if ((valor == null) ||(valor.trim().equals(""))) {
			return null;
		}else {
			return valor.replaceAll("\\.",  "").replaceAll("\\-", "");
		}				
	}
	
	public String getAsString (FacesContext fc, UIComponent c, Object valor) throws ConverterException{
		if ((valor == null) || (valor.toString().trim().equals(""))){
			return null;
		} else {
			return valor.toString().replaceAll("\\.",  "").replaceAll("\\-", "");
		}
	}
}
