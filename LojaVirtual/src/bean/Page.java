package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="page")
@SessionScoped
public class Page {
	private boolean alterar = true;

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}
	
	public void alterarPagina(){
		setAlterar(true);
	}
}
