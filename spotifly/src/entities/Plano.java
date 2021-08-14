package entities;

public class Plano {
	private int tipoPlano;
	private double valorMensal;
	private int acessosSimultanios;
	
	public Plano() {
	}
	
	public Plano(int tipoPlano, double valorMensal, int acessosSimultanios) {
		super();
		this.tipoPlano = tipoPlano;
		this.valorMensal = valorMensal;
		this.acessosSimultanios = acessosSimultanios;
	}

	public int getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(int tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getAcessosSimultanios() {
		return acessosSimultanios;
	}

	public void setAcessosSimultanios(int acessosSimultanios) {
		this.acessosSimultanios = acessosSimultanios;
	}
	
}
