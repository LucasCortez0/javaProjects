package br.com.spotifly.entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	List<Musica> favoritas = new ArrayList<>(); 
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
	
	public List<Musica> getFavoritas(){
		return favoritas;
	}
	public int getTamanhoLista() {
		return favoritas.size();
	}
	public void addMusica(Musica musica) {
		favoritas.add(musica);
	}
	public String getNomeMusica(int i) {
		return favoritas.get(i).getNome();
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
