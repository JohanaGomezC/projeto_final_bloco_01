package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int numero = 0;
	

	@Override
	public void listarTodas() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.printf("O produto com ID: %d foi cadastrado com sucesso!%n", produto.getId());
	}
	
	@Override
	public void procurarPorID( int numero) {
		var produto = buscarNaCollection(numero);
		
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf("O produto com ID: %d não foi encontrado!%n", numero);
		}
	}
	
	@Override
	public void atualizarProduto(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.printf("O produto com ID: %f foi atualizado com sucesso!%n", produto.getId());
		} else {
			System.out.printf("O produto com ID: %f não foi encontrado!%n", numero);
		}
	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			if(listaProdutos.remove(produto) == true) {
				System.out.printf("O produto com ID: %d foi deletado com sucesso!%n", id);
			}
		}else {
			System.out.printf("O produto com ID: %d não foi encontrado!%n", id);
		}
	
		
	}
	
	public int gerarId() {
		return ++ numero;
	}
	
	public Produto buscarNaCollection(int numero) {
		for (var produto : listaProdutos ) {
			if (produto.getId() == numero) {
				return produto;
			}
		}
		return null;
	}

}
