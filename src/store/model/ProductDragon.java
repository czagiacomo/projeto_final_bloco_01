package store.model;

public class ProductDragon extends Product {

	private String color;

	public ProductDragon(String product, int prodNum, int prodType, int quantity, float price, String color) {
		super(product, prodNum, prodType, quantity, price);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void visualize() {
		super.visualize();
		System.out.println("Cor do Dragão: " + this.color);
	}

}
