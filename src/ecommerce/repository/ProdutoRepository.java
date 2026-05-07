package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	//CRUD do produto
	public void listarProdutos();
	public void cadastrarProduto(Produto produto);
	public void atualizarProduto(Produto produto);
	public void deletar(int numero);
	
}
