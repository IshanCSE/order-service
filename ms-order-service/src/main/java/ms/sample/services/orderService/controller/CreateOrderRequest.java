package ms.sample.services.orderService.controller;

import java.util.List;

import ms.sample.services.orderService.model.OrderItem;

public class CreateOrderRequest {
	private int orderTotal;
	private String customerId;
	private List<OrderItem> orderItems;

	public CreateOrderRequest() {
	}

	public CreateOrderRequest(String customerId, int orderTotal, List<OrderItem> orderItems) {
		this.customerId = customerId;
		this.orderTotal = orderTotal;
		this.orderItems = orderItems;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
}