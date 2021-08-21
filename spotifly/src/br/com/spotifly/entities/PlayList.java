package br.com.spotifly.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	private List<Musica> musicas = new ArrayList <>();
	
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	
	public void removerMusica(String nomeDaMusica) throws Exception {
		for(int i = 0; i < musicas.size(); i++) {
			if(musicas.get(i).getNome().equals(nomeDaMusica)) {
				musicas.remove(i);
			}else if(i + 1 == musicas.size()) {
				throw new Exception("Musica não encontrada");
			}
		}
	}
	public void removerMusicaInt(int num) {
		musicas.remove(num);
	}
	public int tamanhoPlayList() {
		return musicas.size();
	}
	public List<Musica> getListMusicas() {
		return musicas;
	}
	public Musica getMusica(int i) {
		return musicas.get(i);
	}
	public String getNomeMusica(int i) {
		return musicas.get(i).getNome();
	}
	
	@Override
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < musicas.size(); i++) {
			sb.append(i + 1 + ". ");
			sb.append(musicas.get(i) + "\n");
		}
		return sb.toString();
	}
	
	
	
}
