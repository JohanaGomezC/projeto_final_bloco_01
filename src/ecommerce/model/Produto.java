package ecommerce.model;

public abstract class Produto {

	private int id;
	private int categoria;
	private String nome;
	private float preco;

	// Metodo Construtor
	public Produto(int id, int categoria, String nome, float preco) {
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {

		String categoria = "";

		switch (this.categoria) {
		case 1:
			categoria = "Femenino";
			break;
		case 2:
			categoria = "Masculino";
			break;
		case 3:
			categoria = "Infantil";
			break;
		}

		System.out.println("\n\n*****************************************************");
		System.out.println("Dados do Produto");
		System.out.println("*****************************************************");
		System.out.println("ID do produto: " + this.id);
		System.out.println("Nome do produto: " + this.nome);
		System.out.println("Categoria do produto: " + categoria);
		System.out.printf("Preço do produto: R$ %.2f%n", this.preco);
	}
}
