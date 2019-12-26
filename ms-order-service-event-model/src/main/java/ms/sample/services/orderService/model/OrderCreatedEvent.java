package ms.sample.services.orderService.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class OrderCreatedEvent implements OrderEvent {
	private int orderTotal;
	private String customerId;
	private List<OrderItem> orderItems;

	public OrderCreatedEvent() {
	}

	public OrderCreatedEvent(String customerId, int orderTotal, List<OrderItem> orderItems) {
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

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}