package ex.heranca.ContaBancaria;

public class Conta {
	
	private String titular;
	//mudar de private para protected
	protected double saldo;
	
	public void sacar(double valor) {
		if(valor <= 0) {
			System.out.println("Valor deve ser maior que zero");
		}else if(saldo >= valor) {
			saldo -= valor;
			System.out.println("Saldo realizado com sucesso! Saldo atual: " + saldo);
		}else {
			System.out.println("Saldo insuficiente.");
		}
		
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			saldo += valor;
			System.out.println("Deposito realizado com sucesso! Saldo atual: " + saldo);
		}else {
			System.out.println("O valor deve ser maior que zero.");
		}
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo){
		this.saldo= saldo;
	}
	
	//getters e setters
}
