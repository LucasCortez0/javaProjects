package br.com.spotifly.entities;

public class Album {
	private String nome;
	private Artista artista;
	private PlayList musicas;
	
	public Album(String nome, Artista artista, PlayList musica) {
		this.nome = nome;
		this.artista = artista;
		this.musicas = musica;
	}
	
	public PlayList getMusicas() {
		return musicas;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	
	@Override
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Album: " + nome + " | Artista: " + artista.getNome() + " | Gênero musical: " + artista.getGeneroMusical());
		return sb.toString();
	}
}
