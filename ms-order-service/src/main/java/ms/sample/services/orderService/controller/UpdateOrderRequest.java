package ms.sample.services.orderService.controller;

import java.util.List;

import ms.sample.services.orderService.model.OrderItem;

public class UpdateOrderRequest {
	public UpdateOrderRequest(List<OrderItem> orderItems, int orderTotal) {
		super();
		this.orderItems = orderItems;
		this.orderTotal = orderTotal;
	}

	private List<OrderItem> orderItems;
	private int orderTotal;
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

}
