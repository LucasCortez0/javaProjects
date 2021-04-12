package application;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entities.Banco;

public class Main {
public static int operacao;
public static int contaLista = 0;
public static List <Banco> list = new ArrayList<>();
public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		contaLista = 0;
		boolean programaEmExecucao = true;
		while(programaEmExecucao == true) {			
			System.out.printf("1.Abrir conta\n2.Fechar Conta\n3.AcessarConta\n4.sair\n5.veja todos os clientes (apenas para o programador).\n");
			System.out.print("digite: ");
			operacao = sc.nextInt();
			if(operacao == 1) {
				adicionarConta();							
			}else if(operacao == 2) {
				removerConta();
			}else if(operacao == 3) {
				acessarConta();
			}else if(operacao == 4) {
				programaEmExecucao = false;
			}else if (operacao == 5) {
				aiPapai();
			}else {
				System.out.printf("opeção invalida, digite um dos cógidos informados\n\n");
			}
		}		
		sc.close();
	}
	public static void adicionarConta() {
		list.add(new Banco());
		do {
			System.out.print("\nInforme o número da conta: ");
			int numConta = sc.nextInt();
			for(int i = 1; i < list.size() + 1; i++) {			
				if (list.size() > 1) {					
					if(list.get(i - 1).getNumConta() == numConta) {
						System.out.println("Número de conta ja cadastrado");
						System.out.print("Tente outro número: ");
						numConta = sc.nextInt();
						i = i - 1;
					}else if (list.size() - 1 == i) {
						list.get(contaLista).setNumConta(numConta);
						i += 1;
					}
				}else {
					list.get(i - 1).setNumConta(numConta);
				}
			}					
		}while(list.get(contaLista).getNumConta() == 0);	
		
		System.out.print("Informe o nome: ");
		sc.nextLine();
		list.get(contaLista).setDono(sc.nextLine());
		boolean digitadoCerto = true;
		do {
			System.out.print("tipio de conta (cc = conta corrente/cp = conta poupança): ");
			String tipo = sc.next();
			if(list.get(contaLista).abrirConta(tipo) == 1) {
				System.out.print("erro, Você deve digitar 'cc' ou 'cp'\n\n");
				digitadoCerto = false;
			}else {
				digitadoCerto = true;
			}
		}while(digitadoCerto == false);
		System.out.println("CONTA CRIADA! ");
		System.out.printf("\nNumero da conta: %d \nNome: %s \nTipo de conta: %s", list.get(contaLista).getNumConta(), list.get(contaLista).getDono(), list.get(contaLista).getTipo());
		System.out.printf("\nSaldo atual: %.2f\n\n", list.get(contaLista).getSaldo());
		contaLista++;
		
		
	}
	public static void removerConta() {
		System.out.printf("\natenção! para remover uma conta, o seu saldo deve ser de zero reais!\n");
		System.out.print("Digite o número da conta: ");
		int numeroDaConta = sc.nextInt();
		if(list.size() == 0) {
			System.out.println("Conta não encontrada!");
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNumConta() == numeroDaConta) {
				System.out.printf("\nNome: %s\nConta: %d\n", list.get(i).getDono(), list.get(i).getNumConta());
				char confirma;
				do {
					if(list.get(i).getSaldo() > 0) {
						System.out.printf("Seu saldo é de R&%.2f, desejar sacar e fechar a conta s/n ?", list.get(i).getSaldo());
					}else if (list.get(i).getSaldo() < 0) {
						System.out.println("Sua conta está negativa, gostaria de pagar e fechar a conta s/n ?");
					}else {
						System.out.print("Deseja mesmo remover sua conta s/n ? ");
					}
					confirma = sc.next().charAt(0);		
					if(confirma == 's') {
						list.remove(i);
						System.out.printf("Conta Removida!\n\n");
						contaLista -= 1;
					}else if (confirma == 'n') {						
						System.out.println("A conta não foi removida, fim de operação.");
					}else {
						System.out.printf("\nVocê deve digitar: sim(s) ou não(n)\n");
					}					
				}while(!(confirma == 's' || confirma == 'n'));				
			}else if(i + 1 == list.size()) {
				System.out.println("Conta não encontrada!");
			}
		}		
	}
	public static void acessarConta() {
		int cliente;		
		do {					
			System.out.println("Digite sua conta: ");
			int numConta = sc.nextInt();
			cliente = encontrarConta(numConta);
			if(cliente == -1) {
				System.out.printf("Cliente não encontrado, tente novamente.\n\n");
			}
		}while(cliente == -1);
		System.out.println("Cliente: " + list.get(cliente).getDono() + ", Saldo: R$" + list.get(cliente).getSaldo());
		System.out.printf("Selecione a operação: \n");
		System.out.printf("1.Sacar \n2.Deposita \n3.Pagar mensalidade\n4.Voltar\n");
		System.out.print("Digite: ");
		int operacao = sc.nextInt();
		if(operacao == 1) {
			sacar(cliente);
		}else if (operacao == 2) {
			depositar(cliente);
		}else if (operacao == 3) {
			pagarMensalidade(cliente);
		}
	}
	public static void sacar(int i) {
		System.out.printf("Saldo em conta: R$%.2f\n", list.get(i).getSaldo());
		System.out.print("Informe o valor que será sacado: R$");
		double valorSaque = sc.nextDouble();
		int libera = 0;
		do {
			if(valorSaque > list.get(i).getSaldo()) {
				System.out.printf("saldo indisponivel, seu saldo é de: R$%.2f\n", list.get(i).getSaldo());
				System.out.print("digite o valor: R$");
				valorSaque = sc.nextDouble();
			}else {
				list.get(i).setSaldo(list.get(i).getSaldo() - valorSaque);
				System.out.printf("Saque efetuado, seu saldo agora é de: R$%.2f\n\n", list.get(i).getSaldo());
				libera = 1;
			}
		}while(libera == 0);
		
	}
	public static void depositar(int i) {
		System.out.print("Informe o valor do depósito: R$");
		list.get(i).setSaldo(list.get(i).getSaldo() + sc.nextDouble());
		System.out.printf("Deposito efetuado: R$%.2f\n", list.get(i).getSaldo());
	}
	public static void pagarMensalidade(int i) {
		if(list.get(i).getTipo() == "conta corrente") {
			list.get(i).setSaldo(list.get(i).getSaldo() - 12);
			System.out.println("mensalidade paga!");
			System.out.printf("Saldo após o pagamento: R$%.2f\n", list.get(i).getSaldo());			
		}else if(list.get(i).getTipo() == "conta poupança") {
			list.get(i).setSaldo(list.get(i).getSaldo() - 20);
			System.out.println("mensalidade paga!");
			System.out.printf("Saldo após o pagamento: R$%.2f\n", list.get(i).getSaldo());	
		}
	}
	public static void aiPapai() {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("(%d)conta: %d, Nome: %s, saldo: R$%.2f.\n", i, list.get(i).getNumConta(), list.get(i).getDono(), list.get(i).getSaldo());
		}
	}
	public static int encontrarConta(int numConta) {
		for(int i = 0; i < list.size(); i++) {
			if (numConta == list.get(i).numConta) {
				return i;
			}
		}
		return -1;
	}

}
