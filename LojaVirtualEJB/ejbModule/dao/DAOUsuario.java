package dao;

import javax.ejb.Stateless;

import model.Usuario;

@Stateless
public class DAOUsuario extends DAOJPA<Usuario> {
	
	public DAOUsuario() {
		super();
	}
	
	public Usuario findByLogin(String login) {
		return (Usuario) super.findByQuery("select u from Usuario u where u.login = '"+ login +"'");
	}

	public Usuario findByLoginSenha(String login, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
