package store.repository;

import store.model.Product;

public interface StoreRepository {

	// CRUD dos Produtos
	public void searchByProdNum(int num);

	public void listAll();

	public void create(Product prod);

	public void update(Product prod);

	public void delete(int num);

	// Métodos de Compra e Venda
	public void sell(int num, int quantity);

	public void buy(int num, int quantity);

}
