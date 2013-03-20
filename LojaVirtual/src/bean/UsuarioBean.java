package bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import model.Usuario;
import controller.ControladorGeralRemote;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	
	@EJB
	private ControladorGeralRemote controlador;
	
	private boolean admin;
	private boolean logado = true;
	private String login;
	private String pass;
	private String pass2;
	private String uf;
	
	private Usuario usuario;
	private FacesContext fc;
	private Locale locale;
	
	public Map<String, String> getEstadosSul(){
		Map<String, String> mapa = new HashMap<String, String>(); 
		mapa.put("PR","Paraná");
		mapa.put("SC","Santa Catarina");
		mapa.put("RS","Rio Grande do Sul");
		return mapa;
	}
	
	public void salvarCadastro() {
		if (usuario == null) {
			usuario = new Usuario();
		}
	}	
	
	public void validaSenha(ActionEvent e){
		System.out.println(pass + " " + pass2);
		if (pass != pass2) {
			pass = "";
			pass2 = "";
			fc = FacesContext.getCurrentInstance();
			String msg = fc.getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString("senhaDiferente");
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			fc.addMessage("pass2", fm);
		}
	}
	
	public void Testeadmin() throws IOException{
		logado = true;
		login = usuario.getLogin();
		FacesContext fc = FacesContext.getCurrentInstance();
		NavigationHandler nav = fc.getApplication().getNavigationHandler();
		nav.handleNavigation(fc, null, "/LojaVirtual/pages/meusDados.faces?faces-redirect=true");
	}
	
	public java.sql.Date sqlDate(java.util.Date calendarDate){
		return new java.sql.Date(calendarDate.getTime());
	}
	
	public UsuarioBean() {
		usuario = new Usuario();
		
		fc = FacesContext.getCurrentInstance();
		admin = false;
		logado = false;
		locale = fc.getExternalContext().getRequestLocale();
		login = "";
		pass = "";
	}
	
	public void SetaLogin(FacesContext fc, UIComponent comp, Object value) {
		System.out.println("SetaLogin - " + value.toString());
		login = value.toString();
		
	}

	public void ValidaUsuario(FacesContext fc, UIComponent comp, Object value) {
		pass = value.toString();
		
		usuario = controlador.logar(login, pass);

		if (usuario != null) {
			System.out.println(usuario);
			if (usuario.getSenha().equals(value.toString())) {
				System.out.println(usuario);
				setLogado(true);
				setUsuario(usuario);
				this.admin = usuario.isNivel();
				this.logado = true;
				return;
			}
		}
		login = "";
		pass = "";
		fc = FacesContext.getCurrentInstance();
		String msg = fc.getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString("loginfail");
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		fc.addMessage(null, fm);
	}

	public void logout() {
		fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				true);
		session.invalidate();
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void espanholLocale() {  
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();  
		locale = new Locale("es", "ES");
        viewRoot.setLocale(locale);
	}  
	
	public void portuguesLocale() {  
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();  
		locale = new Locale("pt", "BR");  
		viewRoot.setLocale(locale);  
	}  
	
	public void alemaoLocale() {  
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();  
		locale = new Locale("de", "DE");  
		viewRoot.setLocale(locale);  
	}

	public void RecuperarSenha() {
		if (login != null){
			fc = FacesContext.getCurrentInstance();
			usuario = controlador.PesquisarUsuario(login);


			if (usuario == null) {
				String msg = fc.getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString("naoCadastrado");
				FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				fc.addMessage("recUser", fm);
			} else{
				String msg = fc.getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString("msgSucesso");
				FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
				
				usuario.setSenha("a");
				usuario = null;
				fc.addMessage("recUser", fm);			
			}
		}else{
			fc = FacesContext.getCurrentInstance();
			String msg = fc.getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString("naoCadastrado");
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			fc.addMessage("recUser", fm);
		}
	}

	public FacesContext getFc() {
		return fc;
	}

	public void setFc(FacesContext fc) {
		this.fc = fc;
	}

	public void criarUsuario() {
		System.out.println(usuario);		
		
		controlador.cadastrarUsuario(usuario);
		UsuarioBean bean = (UsuarioBean) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), null, "user");
		
		bean.setUsuario(usuario);
		bean.setLogado(true);
		bean.setAdmin(usuario.isNivel());
		
		String msg = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msgs").getString("accCriada");
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg , msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		System.out.println(pass2);
		this.pass2 = pass2;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}