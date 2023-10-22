package ex.heranca.ContaBancaria;

public class ContaPoupanca extends Conta {
	private double taxaDeJuros;
	
	public void calcularJuros() {
		double juros = this.saldo * taxaDeJuros;
		System.out.println("Juros atuais: " + juros);
	}
	public void sacar(double valor) {
		double taxaSaque = 0.01;
		super.sacar(valor + taxaSaque);
	}

}
