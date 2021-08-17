package view;

import java.util.Scanner;

import entities.Usuario;

public class ViewMenu {
	public static Scanner sc = new Scanner(System.in);
	public static int inicializador() {
		int opc = -1;
		while(opc < 0 || opc > 2) {
			System.out.println("1.Login");
			System.out.println("2.Criar conta");
			System.out.println("0.Finalizar");
			System.out.print("Digite: ");
			opc = sc.nextInt();
			if(opc < 0 || opc > 2) {
				System.out.println("Comando desconhecido\n");
			}
		}
		return opc;
	}
	
	public static Usuario viewLogin() {
		System.out.print("Informe o nome de usuário: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Informe a sua senha: ");
		int senha = sc.nextInt();
		Usuario usuario = new Usuario(nome, 0, senha, null);
		return usuario;
	}
	
	public static void msgErro(String erro) {
		System.out.println("Erro: " + erro);
	}
	
	public static void msg(String msg) {
		System.out.println(msg);
	}
	
	public static Usuario criarConta() {
		System.out.print("Informe o seu nome (também sera usado no login): ");
		sc.nextLine();
		String nome = sc.nextLine();
		int senha1 = 0;
		int senha2 = 1;
		while(senha1 != senha2) {
			System.out.print("Informe a sua senha: ");
			senha1 = sc.nextInt();
			System.out.print("Digite a senha novamente: ");
			senha2 = sc.nextInt();
			if(senha1 != senha2) {
				System.out.println("Senhas diferentes, tente novamente");
			}
		}
		Usuario usuario = new Usuario(nome, 0, senha1, null);
		return usuario;
	}
	
	public static int selecionaPlano() {
		int plano = 0;
		while(plano < 1 || plano > 3) {
			System.out.println();
			System.out.println("Plano 1 | Acessos simultâneos: 1 | Valor mensal: R$12,50 ");
			System.out.println("Plano 2 | Acessos simultâneos: 3 | Valor mensal: R$17,99 ");
			System.out.println("Plano 3 | Acessos simultâneos: 5 | Valor mensal: R$21,99 ");
			System.out.print("Digite o plano (1, 2 ou 3): ");
			plano = sc.nextInt();
			if(plano < 1 || plano > 3) {
				System.out.println("\nPlano não encontrado, você deve digita 1, 2 ou 3");
			}
		}
		return plano;
	}

}
