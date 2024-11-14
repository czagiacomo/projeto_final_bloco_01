package store;

import java.util.Scanner;

import store.model.ProductDragon;
import store.model.ProductJewellery;

public class Menu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int option;

		// Teste do Produto Ovo de Dragão
		ProductDragon babyDragon = new ProductDragon("Ovo de Dragão", 123, 1, 50, 500.0f, "Verde Musgo");
		babyDragon.visualize();
		babyDragon.buy(10);
		babyDragon.sell(2);
		System.out.println("------------------------------");
		babyDragon.visualize();
		System.out.println("\n");

		// Teste do Produto Jóias de Dragão
		ProductJewellery dragonGem1 = new ProductJewellery("Colar de Esmeraldas", 456, 2, 8, 1200.0f,
				"Platina e Esmeraldas Lapidadas");
		dragonGem1.visualize();
		dragonGem1.buy(1);
		dragonGem1.sell(3);
		System.out.println("------------------------------");
		dragonGem1.visualize();
		System.out.println("\n");

		ProductJewellery dragonGem2 = new ProductJewellery("Colar de Diamantes", 456, 2, 1, 1200.0f,
				"Ouro e Diamantes");
		dragonGem2.visualize();
		dragonGem2.buy(5);
		System.out.println("------------------------------");
		dragonGem2.visualize();
		System.out.println("\n");

		while (true) {
			System.out.println("Ms Zagia Draconic Grove");
			System.out.println("Melhor bazar de Itens Draconicos!\n");
			System.out.println("1- Criar novo item");
			System.out.println("2- Listar todos os itens");
			System.out.println("3- Editar item");
			System.out.println("4- Deletar item");
			System.out.println("5- Vender");
			System.out.println("6- Comprar");
			System.out.println("7- Buscar item por número");
			System.out.println("0- Sair da Loja");

			option = scan.nextInt();

			if (option == 0) {
				System.out.println("Saindo da Loja...");
				scan.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println("Criar novo item");
				break;
			case 2:
				System.out.println("Listar todos os itens");
				break;
			case 3:
				System.out.println("Editar item");
				break;
			case 4:
				System.out.println("Deletar item");
				break;
			case 5:
				System.out.println("Vender item");
				break;
			case 6:
				System.out.println("Comprar item");
				break;
			case 7:
				System.out.println("Verificar item por número");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}

		}

	}

}
