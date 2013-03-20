package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Pessoa pessoa;
	private String cep;
	private String Endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco() {
		super();
	}

	public Endereco(String cep, String Endereco, String numero, String complemento,
			String bairro, String cidade, String estado) {
		super();
		this.cep = cep;
		this.Endereco = Endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return Endereco;
	}
	
	public String getEndereco2() {
		return Endereco +", "+ numero +", "+ complemento;
	}

	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	//Retorna o Endereco completo.
	@Override
	public String toString() {
		return getEndereco() +", "+ getNumero() +" "+ getComplemento() +", "+ getBairro() +"\n"+
				getCep() +" "+ getCidade() +" - "+ getEstado() +"\n";
	}
	
}
