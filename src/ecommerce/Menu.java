package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.ProdutoController;
import ecommerce.model.Produto;
import ecommerce.model.Roupa;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {

		criarProdutosTeste();

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                MODA - ECOMMERCE                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os produtos             ");
			System.out.println("            3 - Buscar produto por ID                ");
			System.out.println("            4 - Atualizar Dados do produto           ");
			System.out.println("            5 - Deletar produto                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\n MODA ECOMMERCE - OBRIGADO POR NOS PREFERIR");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrando produto\n\n");

				cadastrarProduto();

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os produtos\n\n");

				listaProdutos();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do produto por ID\n\n");

				procurarProdutoPorID();

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do produto\n\n");

				atualizarProduto();

				keyPress();
				break;
			case 5:
				System.out.println("Deletar produro\n\n");
				
				deletarProduto();
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("*****************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Johana Gómez Cardona - johagomez9806@gmail.com");
		System.out.println("https://github.com/JohanaGomezC");
		System.out.println("*****************************************************");
	}

	private static void listaProdutos() {
		produtoController.listarTodas();
	}

	private static void cadastrarProduto() {

		System.out.print("Digite o nome do produto: ");
		String nome = leia.nextLine();

		System.out.print("Digite preço do produto: (R$) ");
		float preco = leia.nextFloat();
		leia.nextLine();

		System.out.print("Digite a Categoria do produto (1 - Femenino | 2 - Masculino ) : ");
		int categoria = leia.nextInt();
		leia.nextLine();

		switch (categoria) {
		case 1 -> {
			System.out.println("Digite o tamanho do Produto (P | M | G | GG) : ");
			String tamanho = leia.nextLine();

			System.out.println("Digite a quantidade do produto : ");
			int quantidade = leia.nextInt();

			produtoController.cadastrarProduto(
					new Roupa(produtoController.gerarId(), categoria, nome, preco, tamanho, quantidade));
		}
		case 2 -> {
			System.out.println("Digite o tamanho do Produto (P | M | G | GG) : ");
			String tamanho = leia.nextLine();

			System.out.println("Digite a quantidade do produto : ");
			int quantidade = leia.nextInt();
			produtoController.cadastrarProduto(
					new Roupa(produtoController.gerarId(), categoria, nome, preco, tamanho, quantidade));
		}
		default -> System.out.println("Categoria do Produto Inválida!");
		}
	}

	private static void criarProdutosTeste() {
		produtoController.cadastrarProduto(new Roupa(produtoController.gerarId(), 1, "Vestido Floral", 150f, "P", 3));
		produtoController.cadastrarProduto(new Roupa(produtoController.gerarId(), 2, "Bermuda Jeans", 89.90f, "M", 5));
		produtoController.cadastrarProduto(new Roupa(produtoController.gerarId(), 1, "Blusa Listrada", 59.99f, "G", 7));
		produtoController.cadastrarProduto(new Roupa(produtoController.gerarId(), 2, "Camiseta Polo", 119.90f, "M", 4));

	}

	private static void procurarProdutoPorID() {

		System.out.print("Digite o ID do produto: ");
		int numero = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorID(numero);

	}

	private static void atualizarProduto() {
		System.out.print("Digite o ID do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			int categoria = produto.getCategoria();
			String nome = produto.getNome();
			float preco = produto.getPreco();

			System.out.printf("Categoria atual: %d\nNova Categoria (pressione ENTER para manter): ", categoria);
			String entrada = leia.nextLine();
			categoria = entrada.isEmpty() ? categoria : Integer.parseInt(entrada);

			System.out.printf("Nome atual do produto: %s\nNovo Nome (pressione ENTER para manter): ", nome);
			entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			System.out.printf("Preço atual: R$ %.2f\nNovo Preço (pressione ENTER para manter): ", preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(',', '.'));

			switch (categoria) {
			case 1 -> {
				String tamanho = ((Roupa) produto).getTamanho();
				int quantidade = ((Roupa) produto).getQuantidade();

				System.out.printf("Tamanho atual: %s\nNovo Tamanho (pressione ENTER para manter): ", tamanho);
				entrada = leia.nextLine();
				tamanho = entrada.isEmpty() ? tamanho : entrada;

				System.out.printf("Quantidade atual: %d\nNova Quantidade (pressione ENTER para manter): ", quantidade);
				entrada = leia.nextLine();
				quantidade = entrada.isEmpty() ? quantidade : Integer.parseInt(entrada);

				produtoController.atualizarProduto(new Roupa(id, categoria, nome, preco, tamanho, quantidade));
			}
			default -> System.out.println("Categoria inválida!");
			}

		}
	}

	private static void deletarProduto() {

		System.out.print("Digite o ID do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		System.out.print("\nTem certeza que deseja excluir este produto? (S/N): ");
		String confirmacao = leia.nextLine();

		if (confirmacao.equalsIgnoreCase("S")) {
			produtoController.deletar(id);
		} else {
			System.out.println("\nOperação cancelada.");
		}

	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para Continuar ...");
		leia.nextLine();
	}

}
