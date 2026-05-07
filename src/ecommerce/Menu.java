package ecommerce;

import java.util.Scanner;

import ecommerce.model.Produto;
import ecommerce.model.Roupa;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Teste classe Roupa
		Roupa r1 = new Roupa(2, 2, "Bermuda Jeans", 80.0f, "M", 1);
		r1.visualizar();
		
		Roupa r2 = new Roupa(1, 2, "Vestido Floral", 150.0f, "P", 2);
		r2.visualizar();
		
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
			System.out.println("            3 - Atualizar Dados do produto           ");
			System.out.println("            4 - Deletar produto                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			
			opcao = leia.nextInt();
			
			if (opcao == 0) {
				System.out.println("\n MODA ECOMMERCE - OBRIGADO POR NOS PREFERIR");
				sobre();
			    leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println( "Cadastrando produto\n\n");
				break;
			case 2:
				System.out.println( "Listar todos os produtos\n\n");
				break;
			case 3:
				System.out.println("Atualizar dados do produto\n\n");
				break;
			case 4:
				System.out.println( "Deletar produro\n\n");
				break;
			default: 
					System.out.println("\nOpção Inválida");
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

}
