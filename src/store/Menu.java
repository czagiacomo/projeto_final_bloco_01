package store;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int option;

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
