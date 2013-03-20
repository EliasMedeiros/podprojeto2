package dao;

import javax.ejb.Stateless;

import model.Venda;

@Stateless
public class DAOVenda extends DAOJPA<Venda> {
	
	public DAOVenda() {
		super();
	}

}
