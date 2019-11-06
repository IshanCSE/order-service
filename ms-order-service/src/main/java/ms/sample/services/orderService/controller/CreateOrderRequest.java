package ms.sample.services.orderService.controller;

import java.util.List;

import ms.sample.services.orderService.Product;

public class CreateOrderRequest {
	private int orderTotal;
	private String customerId;
	private List<Product> products;

	public CreateOrderRequest() {
	}

	public CreateOrderRequest(String customerId, int orderTotal, List<Product> products) {
		this.customerId = customerId;
		this.orderTotal = orderTotal;
		this.products = products;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<Product> getProducts() {
		return products;
	}
}