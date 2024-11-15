package store;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import store.controller.StoreController;
import store.model.ProductDragon;
import store.model.ProductJewellery;
import store.util.Designs;

public class Menu {

	public static void main(String[] args) {

		StoreController products = new StoreController();
		Scanner scan = new Scanner(System.in);

		int prodNum, prodType, quantity, password;
		int option = 0, optionAdm = 0;
		boolean admAccess = false;
		String product, color, material;
		float price;

		do {

			if (admAccess) {

				Designs.menuAdm();

				try {
					optionAdm = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite um valor válido");
					scan.nextLine();
					optionAdm = 0;
				}

				if (optionAdm == 0) {
					System.out.println("Saindo da Loja...");
					scan.close();
					System.exit(0);
				}

				switch (optionAdm) {

				case 1:
					System.out.println("Itens Disponíveis na Loja:");
					products.listAll();
					break;
				case 2:
					System.out.println("Criar novo item");

					System.out.println("Digite nome do Produto:  ");
					scan.skip("\\R?");
					product = scan.nextLine();
					System.out.println("Digite o valor do Produto: ");
					scan.skip("\\R?");
					price = scan.nextFloat();
					do {
						System.out.println("Digite o tipo do Prduto: ");
						System.out.println("1- Ovos de Dragão");
						System.out.println("2- Jóias de Dragão");
						scan.skip("\\R?");
						prodType = scan.nextInt();
					} while (prodType < 1 && prodType > 2);
					System.out.println("Digite a quantidade em estoque: ");
					quantity = scan.nextInt();
					switch (prodType) {
					case 1 -> {
						System.out.println("Digite a cor do Dragão: ");
						scan.skip("\\R?");
						color = scan.nextLine();
						products.create(
								new ProductDragon(product, products.generateNum(), prodType, quantity, price, color));
					}
					case 2 -> {
						System.out.println("Digite o material da Jóia: ");
						scan.skip("\\R?");
						material = scan.nextLine();
						products.create(new ProductJewellery(product, products.generateNum(), prodType, quantity, price,
								material));
					}

					}
					keyPress();
					break;
				case 3:
					System.out.println("Editar item");
					System.out.println("Atualizar o cadastro do item\n");
					System.out.println("Digite o número do produto: ");
					prodNum = scan.nextInt();
					var prodSearch = products.querryCollection(prodNum);
					if (prodSearch != null) {
						prodType = prodSearch.getProdType();
						System.out.println("Digite o Nome do Produto: ");
						product = scan.nextLine();
						System.out.println("Digite a quantidade em estoque: ");
						quantity = scan.nextInt();
						System.out.println("Digite o preço do item: ");
						price = scan.nextFloat();
						switch (prodType) {
						case 1 -> {
							System.out.println("Digite a cor do Ovo: ");
							color = scan.next();
							products.update(new ProductDragon(product, products.generateNum(), prodType, quantity,
									price, color));
						}
						case 2 -> {
							System.out.println("Digite o material da jóia dracônica");
							material = scan.next();
							products.update(new ProductDragon(product, products.generateNum(), prodType, quantity,
									price, material));
						}
						default -> {
							System.out.println("Tipo de produto inválido!");
						}
						}
					} else {
						System.out.println("O produto não foi encontrado!");
					}

					keyPress();
					break;
				case 4:
					System.out.println("Deletar item");
					System.out.println("Digite o número do produto: ");
					prodNum = scan.nextInt();
					products.delete(prodNum);
					keyPress();
					break;

				case 5:
					System.out.println("Abastecer estoque");

					// Teste do Produto Ovo de Dragão
					ProductDragon babyDragon1 = new ProductDragon("Ovo de Dragão", products.generateNum(), 1, 50,
							500.0f, "Verde Musgo");
					products.create(babyDragon1);
					babyDragon1.visualize();
					System.out.println(" ");

					ProductDragon babyDragon2 = new ProductDragon("Ovo de Dragão", products.generateNum(), 1, 20,
							1200.0f, "Preto Azulado");
					products.create(babyDragon2);
					babyDragon2.visualize();
					System.out.println(" ");

					// Teste do Produto Jóias de Dragão
					ProductJewellery dragonGem1 = new ProductJewellery("Colar de Esmeraldas", products.generateNum(), 2,
							8, 1200.0f, "Platina e Esmeraldas Lapidadas");
					products.create(dragonGem1);
					dragonGem1.visualize();
					System.out.println(" ");

					ProductJewellery dragonGem2 = new ProductJewellery("Colar de Diamantes", products.generateNum(), 2,
							1, 1200.0f, "Ouro e Diamantes");
					products.create(dragonGem2);
					dragonGem2.visualize();
					System.out.println(" ");

					keyPress();
					break;

				case 6:
					admAccess = false;
					break;

				default:
					System.out.println("Opção inválida");
					break;

				}

			} else {

				Designs.menu();

				try {
					option = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite um valor válido");
					scan.nextLine();
					option = 0;
				}

				if (option == 0) {
					System.out.println("Saindo da Loja...");
					scan.close();
					System.exit(0);
				}

				switch (option) {

				case 1:
					System.out.println("Insira a senha:");
					scan.skip("\\R?");
					password = scan.nextInt();
					if (password != 123) {
						System.out.println("Senha incorreta, digite a senha 123 para acessar o Menu de Administração");
						admAccess = false;
					} else {
						admAccess = true;
					}
					keyPress();
					break;

				case 2:
					System.out.println("Itens disponíveis na loja: ");
					products.listAll();
					keyPress();
					break;
				case 3:
					System.out.println("Vender item");
					System.out.println("Digite o número do produto: ");
					prodNum = scan.nextInt();
					do {
						System.out.println("Digite a quantidade que deseja vender ");
						quantity = scan.nextInt();
					} while (quantity <= 0);
					products.sell(prodNum, quantity);
					keyPress();
					break;
				case 4:
					System.out.println("Comprar item");
					System.out.println("Digite o número do produto: ");
					prodNum = scan.nextInt();
					do {
						System.out.println("Digite a quantidade desejada: ");
						quantity = scan.nextInt();
					} while (quantity <= 0);
					products.buy(prodNum, quantity);

					keyPress();
					break;
				case 5:
					System.out.println("Verificar item por número");

					System.out.println("Digite o número do produto: ");
					prodNum = scan.nextInt();
					products.searchByProdNum(prodNum);

					keyPress();
					break;

				default:
					System.out.println("Opção inválida");
					break;
				}

			}

		} while(option != 0 || optionAdm != 0);

	}

	public static void keyPress() {

		try {

			System.out.println("Pressione a tecla enter para continuar");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente da tecla enter");

		}
	}
}
