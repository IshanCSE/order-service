package ms.sample.services.orderService.commands;

import java.util.List;

import ms.sample.services.orderService.model.OrderItem;

public class CreateOrderCommand implements OrderCommand {
	private final String customerId;
	private final int orderTotal;
	private final List<OrderItem> orderItems;

	public CreateOrderCommand(String customerId, int orderTotal, List<OrderItem> orderItems) {
		this.customerId = customerId;
		this.orderTotal = orderTotal;
		this.orderItems = orderItems;
	}

	public String getCustomerId() {
		return customerId;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
}
