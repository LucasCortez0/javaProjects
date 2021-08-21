package br.com.spotifly.view;

import java.util.List;
import java.util.Scanner;

import br.com.spotifly.entities.Album;
import br.com.spotifly.entities.Artista;
import br.com.spotifly.entities.Musica;
import br.com.spotifly.entities.PlayList;

public class ViewAdmin {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int selecionaOpc() {
		int opc = -1;
		while(opc < 0 || opc > 3) {
			System.out.println();
			System.out.println("1. Adicionar album");
			System.out.println("2. Remover album");
			System.out.println("3. Editar album");
			System.out.println("0. Sair");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > 3) {
				System.out.println("Opção inválida");
			}
		}
		return opc;
	}
	
	public static int confirmacaoFinalizacao() {
		System.out.println("Confirmar Upload? ");
		int opc = 0;
		while(opc < 1 || opc > 2) {
			System.out.println("1. Confirmar");
			System.out.println("2. Cancelar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 1 || opc > 2) {
				System.out.println("Comando desconhecido!");
			}
		}
		if(opc == 1) {
			System.out.println("Upload realizado com sucesso!");
		}else if(opc == 2){
			System.out.println("Cancelado!");
		}
		return opc;
	}
	
	public static int selecionarAlbum(List<Album> albuns) {
		System.out.println();
		System.out.println("Albuns!");
		for(int i = 0; i < albuns.size(); i++) {
			System.out.println(i + 1 + ". " + albuns.get(i));
		}
		int operacao = 0;
		while(operacao < 1 || operacao > albuns.size()) {
			System.out.print("Digite o número do album que deseja remover: ");
			operacao = sc.nextInt();
			if(operacao < 1 || operacao > albuns.size()) {
				System.out.println("Album não encontrado");
			}
		}
		System.out.println(albuns.get(operacao - 1));
		System.out.println("Tem certeza que deseja remover esse album ?");
		int opc = 0;
		while(opc < 1 || opc > 2) {
			System.out.println("1. Confirmar");
			System.out.println("2. Cancelar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 1 || opc > 2) {
				System.out.println("Comando desconhecido!");
			}
		}
		if(opc == 1) {
			System.out.println("Album removido");
			return operacao;
		}else {
			System.out.println("Cancelado, o album não foi removido");
		}
		return 0;
	}
	
	public static Album adicionaAlbum(Artista artista, PlayList playlist) {
		System.out.print("Informe o nome do Album: ");
		sc.nextLine();
		String nomeAlbum = sc.nextLine();
		Album album = new Album(nomeAlbum, artista, playlist);
		System.out.println();
		System.out.println(album + " | Quantidade de musicas: " + playlist.tamanhoPlayList());
		System.out.println("O album sera adicionado, Deseja confirmar ?");
		int opc = 0;
		while(opc < 1 || opc > 2) {
			System.out.println("1. Confirmar");
			System.out.println("2. Cancelar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 1 || opc > 2) {
				System.out.println("Comando desconhecido!");
			}
		}
		if(opc == 1) {
			System.out.println("Album adicionado!");
			return album;
		}else {
			System.out.println("Cancelado, o album não foi adicionado");
		}
		return null;	
	}
	

	public static int selecionarAlbumEditar(List<Album> albuns) {
		System.out.println();
		System.out.println("Albuns!");
		for(int i = 0; i < albuns.size(); i++) {
			System.out.println(i + 1 + ". " + albuns.get(i));
		}
		int operacao = 0;
		while(operacao < 1 || operacao > albuns.size()) {
			System.out.print("Digite o número do album que deseja editar: ");
			operacao = sc.nextInt();
			if(operacao < 1 || operacao > albuns.size()) {
				System.out.println("Album não encontrado");
			}
		}
		return operacao;
	}
	
	public static int opcaoEditar(Album album) {
		int opc = -1;
		while(opc < 0 || opc > 3) {
			System.out.println("1. Remover musica");
			System.out.println("2. Adicionar musica");
			System.out.println("3. Editar musica");
			System.out.println("0. Cancelar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > 3) {
				System.out.println("Comando desconhecido!");
			}		
		}
		return opc;
		
	}
	
	public static int removerMusica(Album album) {
		if(album.getMusicas().tamanhoPlayList() == 0) {
			System.out.println("Album sem musicas!");
			return 0;
		}
		System.out.println("Musicas desse album: ");
		System.out.println(album.getMusicas());
		System.out.println("0. Cancelar");
		int opc = -1;
		while(opc < 0 || opc > album.getMusicas().tamanhoPlayList() + 1) {
			System.out.print("Digite qual musica deseja remover do album: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > album.getMusicas().tamanhoPlayList() + 1) {
				System.out.println("Musica não encontrada!");
			}
		}
		if(opc != 0) {
			System.out.println("Musica removida");
		}
		return opc;
	}
	public static Musica adicionarMusica(Album album) {
		System.out.print("Informe o nome da nova Musica: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Informe a duração da musica: ");
		double duracao = sc.nextDouble();
		System.out.println("Musica adicionada!");
		Musica musica = new Musica(nome, duracao, null);
		return musica;
	}
	public static int selecionarMusica(Album album) {
		System.out.println("Musicas deste album: ");
		System.out.print(album.getMusicas());
		System.out.println("0. Cancelar");
		int opc = -1;
		while(opc < 0 || opc > album.getMusicas().tamanhoPlayList()) {
			System.out.print("Digite a musica que deseja editar: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > album.getMusicas().tamanhoPlayList()) {
				System.out.println("Comando invalido!");
			}
		}
		return opc;
	}
	public static Musica editarMusica(Musica musica) {
		System.out.println("Nome da Musica: " + musica.getNome());
		System.out.print("Informe o novo nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("Duração da musica: " + musica.getDuracao());
		System.out.print("Informe a nova duração: ");
		double duracao = sc.nextDouble();
		Musica musicaNova = new Musica(nome, duracao, null);
		System.out.println("Musica alterada com sucesso!");
		return musicaNova;
	}
	public static PlayList criaPlayList(Artista artista) {
		System.out.print("Digite quantas musicas tem o album: ");
		int numMusica = sc.nextInt();
		PlayList playlist = new PlayList();
		for(int i = 0; i < numMusica; i++) {
			sc.nextLine();
			System.out.print("Informe o nome da musica " + (i + 1) + ": ");
			String nome = sc.nextLine();
			System.out.print("Informe a duração da musica: ");
			double duracao = sc.nextDouble();
			Musica musica = new Musica(nome, duracao, artista);
			playlist.addMusica(musica);
		}
		return playlist;
	}
	
	public static Artista adicionarArtista() {
		System.out.print("Informe o nome do artista: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Gênero musical: ");
		String genero = sc.nextLine();
		Artista artista = new Artista(nome, genero);
		return artista;	
	}
	
	public static void msgErro(String msg) {
		System.out.println(msg);
	}
	
	public static void msg(String msg) {
		System.out.println(msg);
	}
}
