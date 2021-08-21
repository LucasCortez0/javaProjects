package br.com.spotifly.view;

import java.util.List;
import java.util.Scanner;

import br.com.spotifly.entities.Album;
import br.com.spotifly.entities.Musica;

public class ViewUsuario {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int inicializador() {
		int opc = -1;
		while(opc < 0 || opc > 3) {
			System.out.println();
			System.out.println("1.Musicas Favoritas");
			System.out.println("2.Mostrar albuns");
			System.out.println("0.Sair");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > 3) {
				System.out.println("Opco invalida");
			}
		}
		return opc;
	}
	
	public static int viewFavoritas(List<Musica> favoritas) {
		if(favoritas.size() < 1) {
			System.out.println("Voce ainda nao tem musicas favoritas");
			return 0;
		}
		System.out.println();
		System.out.println("as suas M�sicas favoritas s�o: ");	
		int numMusica = -1;
		while(numMusica < 0 || numMusica > favoritas.size() + 1) {
			for(int i = 0; i < favoritas.size(); i++) {
				System.out.println(i + 1 + ". " + favoritas.get(i));
			}
			System.out.println("0. voltar");
			System.out.print("Digite o n�mero da musica que deseja ouvir: ");
			numMusica = sc.nextInt();
			if(numMusica < 0 || numMusica > favoritas.size() + 1) {
				System.out.println("Musica n�o encontrada");
			}
		}
		return numMusica;

	}
	public static int viewAlbum(List<Musica> musicas) {
		if(musicas.size() == 0) {
			System.out.println("Este album n�o tem nenhuma musica :(");
			return 0;
		}
		System.out.println();
		System.out.println("Musicas do album:");
		for(int i = 0; i < musicas.size(); i++) {
			System.out.print(i + 1 + ". "+ musicas.get(i) + "\n");
		}
		int numMusica = -1;
		while(numMusica < 0 || numMusica > musicas.size() + 1) {
			System.out.println("0. voltar");
			System.out.print("Digite o n�mero da musica que deseja ouvir: ");
			numMusica = sc.nextInt();
			if(numMusica < 0 || numMusica > musicas.size() + 1) {
				System.out.println("Musica n�o encontrada");
			}
		}
		return numMusica;

	}
	public static int viewAlbuns(List<Album> albuns) {
		System.out.println();
		System.out.println("Albuns!");
		for(int i = 0; i < albuns.size(); i++) {
			System.out.println(i + 1 + ". " + albuns.get(i));
		}
		int operacao = 0;
		while(operacao < 1 || operacao > albuns.size()) {
			System.out.print("Digite o n�mero do album para abrir: ");
			operacao = sc.nextInt();
			if(operacao < 1 || operacao > albuns.size()) {
				System.out.println("Album n�o encontrado");
			}
		}
		return operacao;
	}
	public static int tocarMusica(Musica musica) {
		int opc = 4;
		while(opc < 0 || opc > 3) {
			System.out.println();
			System.out.println(musica);
			System.out.println("TOCANDO MUSICA");
			System.out.println("");
			System.out.println("1. voltar musica");
			System.out.println("2. adicionar musiac aos favoritos");
			System.out.println("3. avan�ar musica");
			System.out.println("0. voltar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
		}
		return opc;
	}
	
	public static void msgErro(String erro) {
		System.out.println(erro);
	}
	public static void msg(String msg) {
		System.out.println(msg);
	}
}
