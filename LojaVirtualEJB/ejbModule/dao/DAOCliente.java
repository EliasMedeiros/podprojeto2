package dao;

import javax.ejb.Stateless;

import model.Cliente;

@Stateless
public class DAOCliente extends DAOJPA<Cliente> {
	
	public DAOCliente() {
		super();
	}

}
