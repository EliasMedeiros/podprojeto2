package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {

	// Constantes informando os tipos de telefones.
	public static final int CELULAR = 0;
	public static final int RESIDENCIAL = 1;
	public static final int COMERCIAL = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Pessoa pessoa;
	private String numero;
	// Informa o tipo do telefone (celular, residencial ou comercial).
	private int tipo;

	public Telefone() {
		super();
	}
	
	public Telefone(String numero, int tipo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
	}

	public Telefone(Pessoa pessoa, String numero, int tipo) {
		super();
		this.pessoa = pessoa;
		this.numero = numero;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}
	
	public String getTipoAsString() {
		switch(this.tipo) {
			case CELULAR:
				return "Celular";
			case COMERCIAL:
				return "Comercial";
			case RESIDENCIAL:
				return "Residencial";
			default:
				return null;
		}
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getTipoNome() {
		switch(this.tipo) {
			case CELULAR : return "Celular";
			case COMERCIAL : return "Comercial";
			case RESIDENCIAL : return "Residencial";
			default : return null;
		}
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", pessoa=" + pessoa + ", numero="
				+ numero + ", tipo=" + tipo + "]";
	}
	
}
