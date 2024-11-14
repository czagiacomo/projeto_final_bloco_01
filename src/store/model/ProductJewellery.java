package store.model;

public class ProductJewellery extends Product {

	private String material;

	public ProductJewellery(String product, int prodNum, int prodType, int quantity, float price, String material) {
		super(product, prodNum, prodType, quantity, price);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void visualize() {
		super.visualize();
		System.out.println("Material da Jóia: " + this.material);
	}

}
