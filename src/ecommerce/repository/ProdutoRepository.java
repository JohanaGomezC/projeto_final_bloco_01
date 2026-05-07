package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	//CRUD do produto
	public void listarTodas();
	public void cadastrarProduto(Produto produto);
	public void procurarPorID(int numero);
	public void atualizarProduto(Produto produto);
	public void deletar(int numero);
	
}
