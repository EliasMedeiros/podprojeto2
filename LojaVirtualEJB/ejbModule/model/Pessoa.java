package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pessoa")
	private List<Telefone> telefone;
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pessoa")
	private Endereco endereco;
	private String email;
	private String cpf;
	private String rg;
	@Temporal(TemporalType.DATE)
	private Calendar datanascimento;
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pessoa")
	private Usuario usuario;

	/*
	 * Construtor vazio
	 */
	public Pessoa() {
		super();
		telefone = new ArrayList<Telefone>();
	}

	/*
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	public void adicionarTelefone(Telefone telefone) {
		this.telefone.add(telefone);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereço) {
		this.endereco = endereço;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Calendar getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	public boolean setDatanascimentoGerada(int dia, int mes, int ano) {
		try {
			this.datanascimento = new GregorianCalendar(ano, mes, dia);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String[] getDatanascimentoSeparada() {
		String dataString = getDatanascimentoAsString();
		String[] data = dataString.split("/");
		data[1] = ""+( (Integer.parseInt(data[1]) - 1) );
		return data;
	}
	
	public String getDatanascimentoAsString() {
		String data = null;
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			data = formatador.format(this.getDatanascimento().getTime());
		} catch (Exception e) {
			System.out.println("Formato de data inválido!");
			e.printStackTrace();
		}
		return data;
	}
	
	public void setDatanascimentoAsString(String dataString) {
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			this.datanascimento.setTime(formatador.parse(dataString));
		} catch (Exception e) {
			System.out.println("Formato de data inválido!");
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		String dados = "Pessoa " + id + "\nNome: " + nome + "\nEmail: " + email + "\nCPF: "
				+ cpf + "\nRG: " + rg + "\nData de Nascimento: " + getDatanascimentoAsString();
		for(Telefone tel : telefone) {
			dados += "\nTelefone " + tel.getTipoNome() + ": "+ tel.getNumero();
		}
		dados += "\n"+usuario.toString();
		dados += "Endereço:\n" + endereco.toString();
		return  dados;
	}

}
