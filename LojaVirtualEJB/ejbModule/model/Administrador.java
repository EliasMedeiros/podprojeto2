package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {

	private int nivelPermissao;

	public int getNivelPermissao() {
		System.out.println(nivelPermissao);
		return nivelPermissao;
	}

	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	@Override
	public String toString() {
		return super.toString()+ "Permissao: Administrador\nNivel da Permissão: "+ nivelPermissao+ "\n";
	}
	
}
