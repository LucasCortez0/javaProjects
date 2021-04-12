package entities;

public class Banco {
	public Integer numConta;
	private String tipo;
	private String dono;
	private Double saldo;
	private Boolean status;
	
	public Banco() {
		status = false;
		saldo = 0.0;
	}
	
	public Integer abrirConta(String tipo) {
		if(tipo.equals("cc")) {
			status = true;
			saldo = 50.00;
			this.tipo = "conta corrente";			
			return 0;
		}else if(tipo.equals("cp")) {
			status = true;
			saldo = 150.00;
			this.tipo = "conta poupança";
			return 0;
		}
		return 1;
		
	}	
	public void fecharConta() {
		if(saldo == 0.0) {
			status = false;
		}
	}	
	public void depoitar(Double valor) {
			saldo += valor;
	}	
	public Boolean sacar(Double valor) {
		if (valor <= saldo) {
			saldo -= valor;
			return true;
		}
		return false;
	}
	public void pagarMensal() {
		if(tipo == "cc") {
			saldo -= 12.00;
		}else if(tipo == "cp") {
			saldo -= 20;
		}
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
