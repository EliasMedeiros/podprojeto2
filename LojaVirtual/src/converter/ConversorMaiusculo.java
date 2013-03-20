package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConversorMaiusculo implements Converter{
	
	public Object getAsObject (FacesContext fc, UIComponent c, String valor) throws ConverterException{
		if ((valor == null) ||(valor.trim().equals(""))) {
			return null;
		}else {
			return valor.toUpperCase();
		}				
	}
	
	public String getAsString (FacesContext fc, UIComponent c, Object valor) throws ConverterException{
		if ((valor == null) || (valor.toString().trim().equals(""))){
			return null;
		} else {
			return valor.toString().toUpperCase();
		}
	}
}
