package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chamada {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date date;
	private List<Alunos> alunos = new ArrayList<>();
	
	public Chamada(Date date) {
		this.date = date;
	}
	
	public String addAluno(Alunos aluno, String nome) {	
		if(alunos.size() != 0) {
			for(int i = 0; i < alunos.size(); i ++) {
				if(alunos.get(i).getNome().equals(nome)) {
					return "Aluno já foi cadastrado!";
				}else if (i == alunos.size() -1 ) {
					alunos.add(aluno);
					return "Aluno cadastrado!";
				}
			}
		}else {
			alunos.add(aluno);
			return "Aluno cadastrado!";
		}
		return "";
		
	}
	
	public String removeAluno(String nome) {
		for(int i = 0; i < alunos.size(); i++) {
			if(nome.equals(alunos.get(i).getNome())) {
				alunos.remove(i);
			return "Aluno removido! ";
			}else if( i == alunos.size() - 1) {
			return "Aluno não encontrado!";
			}
		}
		return "";
	}
	
	public int getNumAlunos() {
		return alunos.size();
	}
	public String getNomeAluno(int i) {
		return alunos.get(i).getNome();
	}
	public void alunoPresente(String presente, int i) {
		if(presente.equals("p")) {
			alunos.get(i).setPresente(true);
		}else if (presente.equals("f")) {
			alunos.get(i).setPresente(false);
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lista de presença dos alunos do dia: " + sdf.format(date) + "\n");
			for(int i = 0; i < alunos.size(); i++) {
				sb.append(alunos.get(i).toString());
			}
		return sb.toString();
	}
}
