package ms.sample.services.orderService;

public class Product {
	private String productId;
	private int count;
	
	public Product(String productId, int count) {
		super();
		this.productId = productId;
		this.count = count;
	}
	public String getProductId() {
		return productId;
	}
	public int getCount() {
		return count;
	}
	
}
