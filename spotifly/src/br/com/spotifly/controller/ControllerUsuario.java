package br.com.spotifly.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.spotifly.entities.Album;
import br.com.spotifly.entities.Artista;
import br.com.spotifly.entities.Musica;
import br.com.spotifly.entities.PlayList;
import br.com.spotifly.entities.Usuario;
import br.com.spotifly.view.ViewUsuario;

public class ControllerUsuario {
	
	public static Usuario usuario;
	public static List<Album> albuns = new ArrayList<>();
	
	public ControllerUsuario() {
		
	}
	
	public static void controlador(Usuario user) {
		usuario = user;
		int opc = -1;
		ViewUsuario.msg("|||||||||||S|P|O|T|I|F|L|Y|||||||||||");
		ViewUsuario.msg("User: " + usuario.getNome());
		while(opc != 0) {
			opc = ViewUsuario.inicializador();
			switch(opc) {
			case 1:
				favoritas();
				break;
			case 2:
				albuns();
				break;
			case 0:
				ViewUsuario.msg("Sess�o encerrada\n");
			}
		}
	}
	
	public static void favoritas() {
		List<Musica> favoritas = usuario.getFavoritas();
		int musica = ViewUsuario.viewFavoritas(favoritas);
		if(musica != 0) {
			//Musica musicaEscolhida = favoritas.getMusica(musica - 1);
			int musicaEscolhida = musica - 1;
			tocarMusica(musicaEscolhida, favoritas);
		}
	}
	
	public static void tocarMusica(int musicaEscolhida, List<Musica> favoritas) {
		int opc = 4;
		while(opc != 0) {
			opc = ViewUsuario.tocarMusica(favoritas.get(musicaEscolhida));
			if(opc == 1) {
				if(musicaEscolhida == 0) {
					musicaEscolhida = favoritas.size() - 1;
				}else {
					musicaEscolhida = musicaEscolhida - 1;
				}
			}else if(opc == 3) {
				if(musicaEscolhida == favoritas.size() -1) {
					musicaEscolhida = 0;
				}else {
					musicaEscolhida += 1;
				}
			}else if(opc == 2) {
				
				
			}
		}
	}
	public static void adicionaAlbuns() {
		
		try {
			PlayList playlist = new PlayList();
			Artista artista1 = new Artista("Renato russo", "pop");
			Musica musica11 = new Musica("Faroeste", 8.7, artista1);
			playlist.addMusica(musica11);
			Musica musica12 = new Musica("Tempos perdidos", 2.2, artista1);
			playlist.addMusica(musica12);
			Musica musica13 = new Musica("Bons tempos", 3.1, artista1);
			playlist.addMusica(musica13);
			Album album = new Album("homens do futuro", artista1, playlist);
			albuns.add(album);
			
			PlayList playlist2 = new PlayList();
			Artista artista2 = new Artista("Junior do Rock", "Forro");
			Musica musica21 = new Musica("avi�es aquaticos", 2.4, artista2);
			playlist2.addMusica(musica21);
			Musica musica22 = new Musica("a mais pedida", 2.9, artista2);
			playlist2.addMusica(musica22);
			Musica musica23 = new Musica("jogado na rua", 4.1, artista2);
			playlist2.addMusica(musica23);
			Musica musica24 = new Musica("Doente de amor", 2.2, artista2);
			playlist2.addMusica(musica24);
			Album album2 = new Album("O sem teto", artista2 , playlist2);
			albuns.add(album2);
		}
		catch(Exception e) {
			ViewUsuario.msgErro(e.getMessage());
		}
				
	}
	
	public static void albuns() {
		int albumEscolhido = ViewUsuario.viewAlbuns(albuns);
		if(albumEscolhido != 0) {
			Album album = albuns.get(albumEscolhido - 1);
			List<Musica> musicas = album.getMusicas().getListMusicas();
			int numMusica = ViewUsuario.viewAlbum(musicas);
			if(numMusica != 0) {
				tocarMusicaAlbum(albumEscolhido, numMusica - 1, musicas);
			}			
		}
		
	}
	
	public static void tocarMusicaAlbum(int numAlbum, int musicaEscolhida, List<Musica> favoritas) {
		numAlbum -= 1;
		int opc = 4;
		while(opc != 0) {
			opc = ViewUsuario.tocarMusica(favoritas.get(musicaEscolhida));
			if(opc == 1) {
				if(musicaEscolhida == 0) {
					musicaEscolhida = favoritas.size() - 1;
				}else {
					musicaEscolhida = musicaEscolhida - 1;
				}
			}else if(opc == 3) {
				if(musicaEscolhida == favoritas.size() -1) {
					musicaEscolhida = 0;
				}else {
					musicaEscolhida += 1;
				}
			}else if(opc == 2) {
				String nome = albuns.get(numAlbum).getMusicas().getNomeMusica(musicaEscolhida);
				if(usuario.getTamanhoLista() == 0) {
					usuario.addMusica(albuns.get(numAlbum).getMusicas().getMusica(musicaEscolhida));
					ViewUsuario.msg("Musica adicionada as favoritas!");
				}else{
					for(int i = 0; i < usuario.getTamanhoLista(); i++) {
						if(usuario.getNomeMusica(i).equals(nome)) {
							ViewUsuario.msgErro("Essa musica j� est� nas favoritas");
							break;
						}else if(i + 1 == usuario.getTamanhoLista()) {
							usuario.addMusica(albuns.get(numAlbum).getMusicas().getMusica(musicaEscolhida));
							System.out.println("Musica adicionada as favoritas!!!");
							break;
						}
					}
				}
			}
		}
	}
}
