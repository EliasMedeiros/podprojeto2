package dao;

import javax.ejb.Stateless;

import model.Pessoa;

@Stateless
public class DAOPessoa extends DAOJPA<Pessoa> {
	
	public DAOPessoa() {
		super();
	}
	
	public Pessoa findById(int id) {
		return (Pessoa) super.findByQuery("SELECT p FROM Pessoa p WHERE p.id = "+ id);
	}
	
	public long getQuantidadeDePessoas() {
		return (Long) super.findByQuery("SELECT count(p) FROM Pessoa p");
	}

}
