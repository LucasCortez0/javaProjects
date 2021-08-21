package br.com.spotifly;


import br.com.spotifly.controller.ControllerLogin;
import br.com.spotifly.controller.ControllerUsuario;

public class Application {
	public static void main(String[] args) {
		ControllerUsuario.adicionaAlbuns();
		ControllerLogin.inicializador();
	}
}
