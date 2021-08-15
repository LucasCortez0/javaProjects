package Controller;

import java.util.ArrayList;
import java.util.List;

import entities.Plano;
import entities.Usuario;
import view.ViewMenu;

public class ControllerLogin {
	public static List<Usuario> usuarios;
	
	public static void inicializador() {
		usuarios = new ArrayList<>();
		Usuario usuario1 = new Usuario("admin", 0, 1234, null);
		usuarios.add(usuario1);
		controlador();
	}
	
	public static void controlador() {
		int opc = 1;
		while(opc != 0) {
			opc = ViewMenu.inicializador();
			switch(opc) {
			case 1:
				testaLogin();
				break;
			case 2:
				criarConta();
				break;
			}
		}
	}
	
	public static void testaLogin() {
		Usuario usuario = ViewMenu.viewLogin();
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getNome().equals(usuario.getNome())) {
				if(usuarios.get(i).getSenha() == usuario.getSenha()) {
					chamaUsuario(usuarios.get(i));
				}else {
					ViewMenu.msgErro("Senha invalida");
				}
			}else if(i + 1 == usuarios.size()) {
				ViewMenu.msgErro("Usuario não encontrado");
			}
		}
	}
	
	public static void chamaUsuario(Usuario usuario) {
		if(usuario.getNome().equals("admin")) {
			ControllerAdmin.controlador();
		}else {
			ControllerUsuario.controlador(usuario);
		}
	}
	
	public static void criarConta() {
		Usuario usuario = ViewMenu.criarConta();
		usuario.setNumRegistro(usuarios.size() + 1);
		int numeroEscolhido = ViewMenu.selecionaPlano();
		Plano plano = new Plano();
		//Define plano
		if(numeroEscolhido == 1) {
			plano.setTipoPlano(numeroEscolhido);
			plano.setAcessosSimultanios(1);
			plano.setValorMensal(12.50);
		}else if(numeroEscolhido == 2) {
			plano.setTipoPlano(numeroEscolhido);
			plano.setAcessosSimultanios(3);
			plano.setValorMensal(17.99);
		}else if(numeroEscolhido == 3) {
			plano.setTipoPlano(numeroEscolhido);
			plano.setAcessosSimultanios(5);
			plano.setValorMensal(21.99);
		}
		usuario.setPlano(plano);
		usuarios.add(usuario);
		ViewMenu.msg("Conta registrada!\n");
	}
}
