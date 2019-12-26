package ms.sample.services.orderService.model;

public class OrderItem {
	private String productId;
	private int count;
	private boolean isConfirmed;

	public OrderItem() {

	}

	public OrderItem(String productId, int count) {
		this.productId = productId;
		this.count = count;
		this.isConfirmed = false;
	}

	public String getProductId() {
		return productId;
	}

	public int getCount() {
		return count;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	

}
