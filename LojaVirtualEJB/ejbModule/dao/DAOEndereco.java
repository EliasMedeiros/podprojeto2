package dao;

import javax.ejb.Stateless;

import model.Endereco;

@Stateless
public class DAOEndereco extends DAOJPA<Endereco> {
	
	public DAOEndereco() {
		super();
	}

}
