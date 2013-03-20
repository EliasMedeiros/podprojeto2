package bean;

import java.util.Locale;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="idioma")
@RequestScoped
public class IdiomaBean {
	
	public void mudarLingua(ActionEvent event) {
		System.out.println("teste");
		FacesContext fc = FacesContext.getCurrentInstance();
		HtmlCommandLink link = (HtmlCommandLink) event.getComponent();
		Locale local = new Locale(link.getId());
		fc.getViewRoot().setLocale(local);
		
		ELContext elc = fc.getELContext();
		UsuarioBean pb = (UsuarioBean) fc.getApplication().getELResolver().getValue(elc, null, "user");
		pb.setLocale(local);
	}

}
