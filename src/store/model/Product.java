package store.model;

public abstract class Product {

	private String product;
	private int prodNum;
	private int prodType;
	private int quantity;
	private float price;

	public Product(String product, int prodNum, int prodType, int quantity, float price) {
		this.product = product;
		this.prodNum = prodNum;
		this.prodType = prodType;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public int getProdType() {
		return prodType;
	}

	public void setProdType(int prodType) {
		this.prodType = prodType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean buy(int stock) {

		if (this.getQuantity() < stock) {
			System.out.println("\nQuantidade Indisponível!");
			return false;
		}

		this.setQuantity(this.getQuantity() - stock);
		return true;
	}

	public void sell(int stock) {

		this.setQuantity(this.getQuantity() + stock);

	}

	public void visualize() {

		String type = "";

		switch (this.prodType) {
		case 1:
			type = "Ovos de Dragão";
			break;
		case 2:
			type = "Jóias Dracônicas";
			break;
		case 3:
			type = "Caixinha Surpresa";
		default:
			type = "Produto Indisponível";
		}

		System.out.println("Nome do Produto: " + this.product);
		System.out.println("Código do Produto: " + this.prodNum);
		System.out.println("Tipo do Produto: " + type);
		System.out.println("Quantidade em Estoque: " + this.quantity);
		System.out.println("Preço do Produto: " + this.price);

	}

}
