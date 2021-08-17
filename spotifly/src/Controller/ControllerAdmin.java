package Controller;

import java.util.ArrayList;
import java.util.List;

import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.PlayList;
import view.ViewAdmin;

public class ControllerAdmin {
	public static List<Album> albuns = new ArrayList<>();
	
	public static void controlador() {
		albuns = ControllerUsuario.albuns;
		System.out.println("|C|E|N|T|R|O| |A|D|M|I|N|S|T|R|A|T|I|V|O| |S|P|O|T|I|F|L|Y|");
		int opc = -1;
		while(opc != 0) {
			opc = ViewAdmin.selecionaOpc();
			switch(opc) {
			case 1:
				adicionarAlbum();
				break;
			case 2:
				removerAlbum();
				break;
			case 3:
				editarAlbum();
				break;
			case 0:
				opc = upload(opc);
				break;
			}
		}
	}
	public static void adicionarAlbum() {
		Artista artista = ViewAdmin.adicionarArtista();
		PlayList playlist = ViewAdmin.criaPlayList(artista);
		Album album = ViewAdmin.adicionaAlbum(artista, playlist);
		if(album != null) {
			albuns.add(album);
		}
	}
	public static void removerAlbum() {
		int numAlbum = ViewAdmin.selecionarAlbum(albuns);
		if(numAlbum != 0) {
			albuns.remove(numAlbum - 1);
		}		
	}
	public static void editarAlbum() {
		int numAlbum = ViewAdmin.selecionarAlbumEditar(albuns) - 1;
		int opc = ViewAdmin.opcaoEditar(albuns.get(numAlbum));
		if(opc == 1) {
			int musicaRemover = ViewAdmin.removerMusica(albuns.get(numAlbum));
			if(musicaRemover != 0) {
				albuns.get(numAlbum).getMusicas().removerMusicaInt(musicaRemover - 1);
			}
		}else if(opc == 2) {
			Musica musica = ViewAdmin.adicionarMusica(albuns.get(numAlbum));
			musica.setArtista(albuns.get(numAlbum).getArtista());
			albuns.get(numAlbum).getMusicas().addMusica(musica);
		}else if(opc == 3) {
			int numMusica = ViewAdmin.selecionarMusica(albuns.get(numAlbum)) - 1;
			if(numMusica != -1) {
			Musica musicaEd = ViewAdmin.editarMusica(albuns.get(numAlbum).getMusicas().getMusica(numMusica));
			albuns.get(numAlbum).getMusicas().getMusica(numMusica).setNome(musicaEd.getNome());
			albuns.get(numAlbum).getMusicas().getMusica(numMusica).setDuracao(musicaEd.getDuracao());
			}
		}
	}
	public static int upload(int opc) {
		if(albuns.size() == 0) {
			ViewAdmin.msgErro("Upload não pode ser realizado, deve haver pelo menos 1 album");
			opc =-1;
		}else {
			int opcao = ViewAdmin.confirmacaoFinalizacao();
			if(opcao == 1) {
				ControllerUsuario.albuns = albuns;
			}else if(opcao == 2) {
				opc = -1;
			}
			
		}
		return opc;
	}
}
