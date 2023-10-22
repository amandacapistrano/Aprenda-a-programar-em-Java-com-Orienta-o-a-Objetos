package models;

public class Compra implements Comparable<Compra> {
	private String descricao;
	private Double valor;
	
	
	public Compra(String descricao, Double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getValor() {
		return valor;
	}
	
	@Override
	public int compareTo(Compra outraCompra) {
		// TODO Auto-generated method stub
		return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
	}
	@Override
	public String toString() {
		return "Items da Compra:\nDescrição: " + descricao + ", valor: " + valor + ".";
	}
	

}
