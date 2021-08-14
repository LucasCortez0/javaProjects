package entities;

public class Usuario {
	private String nome;
	private int numRegistro;
	private int senha;
	private Plano plano;
	
	public Usuario(String nome, int numRegistro, int senha, Plano plano) {
		this.nome = nome;
		this.numRegistro = numRegistro;
		this.plano = plano;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(int numRegistro) {
		this.numRegistro = numRegistro;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
}
