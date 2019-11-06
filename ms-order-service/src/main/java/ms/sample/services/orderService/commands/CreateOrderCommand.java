package ms.sample.services.orderService.commands;

import java.util.List;

import ms.sample.services.orderService.Product;

public class CreateOrderCommand implements OrderCommand {
	private final String customerId;
	private final int orderTotal;
	private final List<Product> products;
	public CreateOrderCommand(String customerId, int orderTotal, List<Product> products) {
		this.customerId = customerId;
		this.orderTotal = orderTotal;
		this.products = products;
	}

	public String getCustomerId() {
		return customerId;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public List<Product> getProducts() {
		return products;
	}
}
