package ms.sample.services.orderService.controller;

import java.util.List;

import ms.sample.services.orderService.Order;
import ms.sample.services.orderService.model.OrderItem;

public class OrderDetailResponse {
	private int orderTotal;
	private List<OrderItem> orderItems;
	public OrderDetailResponse(Order order) {
		this.orderTotal = order.getOrderTotal();
		this.orderItems = order.getOrderItems();
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
