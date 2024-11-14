package store.controller;

import java.util.ArrayList;

import store.model.Product;
import store.repository.StoreRepository;

public class StoreController implements StoreRepository {

	private ArrayList<Product> productsList = new ArrayList<Product>();
	int prodNum = 0;

	@Override
	public void searchByProdNum(int num) {
		var product = querryCollection(prodNum);

		if (product != null) {
			product.visualize();
		} else {
			System.out.println("\nNenhum produto com o número " + prodNum + "não foi encontrado");
		}

	}

	@Override
	public void listAll() {
		for (var product : productsList) {
			product.visualize();
		}

	}

	@Override
	public void create(Product prod) {
		productsList.add(prod);
		System.out.println("\nO produto número " + prod.getProdNum() + " foi cadastrado com sucesso!");

	}

	@Override
	public void update(Product prod) {
		var prodSearch = querryCollection(prod.getProdNum());

		if (prodSearch != null) {
			productsList.set(productsList.indexOf(prodSearch), prod);
			System.out.println("\nA conta número: " + prod.getProdNum() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA conta número: " + prod.getProdNum() + " não foi encontrada");
		}

	}

	@Override
	public void delete(int num) {
		var product = querryCollection(prodNum);

		if (product != null) {
			if (productsList.remove(product) == true)
				System.out.println("O produto " + prodNum + " foi deletado!");
		} else {
			System.out.println("\nO produto " + prodNum + " não foi encontrado");
		}

	}

	@Override
	public void sell(int num, int quantity) {
		var product = querryCollection(prodNum);
		if (product != null) {
			product.sell(quantity);
			System.out.println("A venda do produto" + prodNum + " realizada!");
		} else
			System.out.println("\nO produto " + prodNum + " não foi encontrado");

	}

	@Override

	public void buy(int num, int quantity) {
		var product = querryCollection(prodNum);
		if (product != null) {
			if (product.buy(quantity) == true)
				System.out.println("A compra do produto" + prodNum + " realizada!");
		} else
			System.out.println("\nO produto " + prodNum + " não foi encontrado");

	}

	public int generateNum() {
		return ++prodNum;
	}

	public Product querryCollection(int prodNum) {
		for (var product : productsList) {
			if (product.getProdNum() == prodNum) {
				return product;
			}
		}
		return null;
	}

}
