package entities;

public class Alunos {
	private String nome;
	private Boolean presente;
	
	public Alunos(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getPresente() {
		return presente;
	}

	public void setPresente(Boolean presente) {
		this.presente = presente;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		if(presente == true) {
			sb.append(" = presente\n");
		}else if(presente == false) {
			sb.append(" = faltou\n");
		}
		return sb.toString();
	}
	
}
