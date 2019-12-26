package ms.sample.services.orderService.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class OrderUpdatedEvent implements OrderEvent {
	private int orderTotal;
	private List<OrderItem> orderItems;
	private String orderId;

	public OrderUpdatedEvent(int orderTotal, List<OrderItem> orderItems) {
		super();
		this.orderTotal = orderTotal;
		this.orderItems = orderItems;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public String getOrderId() {
		return orderId;
	}
}
