package ecommerce.model;

public class Roupa extends Produto {
	
	private String tamanho;
	private int quantidade;

	public Roupa(int id, int categoria, String nome, float preco, String tamanho, int quantidade ) {
		super(id, categoria, nome, preco);
		
		this.tamanho = tamanho;
		this.quantidade = quantidade;

	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public void visualizar() { //sobrescrita para exibir os demais atributos de roupa
		super.visualizar();
		System.out.println("Tamanho do Produto: " + this.tamanho);
		System.out.println("Quantidade do Produto: " + this.quantidade);
	}
}
