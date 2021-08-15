package entities;

public class Artista {
	String nome;
	String generoMusical;
	
	public Artista(String nome, String generoMusical) {
		super();
		this.nome = nome;
		this.generoMusical = generoMusical;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
