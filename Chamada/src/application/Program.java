package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Alunos;
import entities.Chamada;

public class Program {
	public static Scanner sc = new Scanner(System.in);
	public static Chamada chamada;
	public static void main(String[] args) throws ParseException {
		int operacao;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Informe a data de hoje (dd/mm/yyyy): ");
		Date date = sdf.parse(sc.next());
		chamada = new Chamada(date);
		do {
			System.out.printf("1.Cadastrar alunos \n2.Fazer chamada \n3.Sair \nDigite: ");
			operacao = sc.nextInt();
			switch(operacao) {
			case 1:
				cadastrar();
				break;
			case 2:
				fazerChamada();
				operacao = 3;
				break;	
			case 3:
				
				break;
			default:
				System.out.println("Operação desconhecida! ");
			}
		}while(operacao != 3);
		System.out.println();
		System.out.println(chamada);
		
	}
	public static void cadastrar() {
		System.out.println();
		System.out.println("1.Adicionar");
		if(chamada.getNumAlunos() > 0) {
			System.out.println("2.Remover");
		}
		System.out.print("Digite: ");
		int operacao = sc.nextInt();
		
		if(operacao == 1) {
			System.out.print("Informe o nome do aluno: ");
			sc.nextLine();
			String name = sc.nextLine();
			Alunos aluno = new Alunos(name);
			System.out.println(chamada.addAluno(aluno, name));
		}else if(operacao == 2) {
			System.out.print("Informe o nome do aluno a ser removido: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println(chamada.removeAluno(nome));
			
		}else {
			System.out.println("Operação desconhecida!");
		}
		System.out.println();
	}
	public static void fazerChamada() {
		System.out.println("p. Presente");
		System.out.println("f. Falta");
		for(int i = 0; i < chamada.getNumAlunos(); i ++) {
			System.out.print(chamada.getNomeAluno(i) + " = ");
			String presente = sc.next();
			chamada.alunoPresente(presente, i);
		}
	}

}
