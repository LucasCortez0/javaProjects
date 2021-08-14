package Controller;

import entities.Usuario;

public class ControllerUsuario {
	public static Usuario usuario;
	public static void controlador(Usuario user) {
		usuario = user;
		System.out.println("opaa");
	}
}
