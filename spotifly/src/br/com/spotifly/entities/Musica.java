package br.com.spotifly.entities;

public class Musica {
	private String nome;
	private double duracao;
	private Artista artista;
	
	public Musica(String nome, double duracao, Artista artista) {
		this.nome = nome;
		this.duracao = duracao;
		this.artista = artista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	
	@Override
	public String toString() {
		return nome + " | Duração: " + duracao + " | " + artista;
	}
}
