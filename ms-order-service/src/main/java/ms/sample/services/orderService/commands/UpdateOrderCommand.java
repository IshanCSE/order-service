package ms.sample.services.orderService.commands;

import java.util.List;

import ms.sample.services.orderService.model.OrderItem;

public class UpdateOrderCommand implements OrderCommand {
	private final int orderTotal;
	private final List<OrderItem> orderItems;
	public UpdateOrderCommand(int orderTotal, List<OrderItem> orderItems) {
		super();
		this.orderTotal = orderTotal;
		this.orderItems = orderItems;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
}
