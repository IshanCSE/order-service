package ms.sample.services.orderService;

import java.util.List;

import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import ms.sample.services.inventoryService.model.ProductAddedEvent;
import ms.sample.services.orderService.commands.CreateOrderCommand;
import ms.sample.services.orderService.commands.OrderCommand;
import ms.sample.services.orderService.commands.OrderConfirmedCommand;
import ms.sample.services.orderService.commands.UpdateOrderCommand;
import ms.sample.services.orderService.model.OrderConfirmedEvent;
import ms.sample.services.orderService.model.OrderCreatedEvent;
import ms.sample.services.orderService.model.OrderItem;
import ms.sample.services.orderService.model.OrderState;
import ms.sample.services.orderService.model.OrderUpdatedEvent;

import static io.eventuate.EventUtil.events;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order, OrderCommand> {
	private int orderTotal;
	private String customerId;
	private OrderState state;
	private List<OrderItem> orderItems;

	public List<Event> process(CreateOrderCommand cmd) {
		System.out.println("Processed create order command.........");
		return events(new OrderCreatedEvent(cmd.getCustomerId(), cmd.getOrderTotal(), cmd.getOrderItems()));
	}

	public List<Event> process(UpdateOrderCommand cmd) {
		System.out.println("Processed update order command.........");
		this.orderTotal = cmd.getOrderTotal();
		this.orderItems.addAll(cmd.getOrderItems());
		return events(new OrderUpdatedEvent(cmd.getOrderTotal(), cmd.getOrderItems()));
	}
	
	public List<Event> process(OrderConfirmedCommand cmd) {
		System.out.println("Processed confirm order command.........");
		return events(new OrderConfirmedEvent());
	}

	public void apply(OrderCreatedEvent event) {
		this.setState(OrderState.IN_PROCESS);
		this.setCustomerId(event.getCustomerId());
		this.setOrderItems(event.getOrderItems());
		this.setOrderTotal(event.getOrderTotal());
	}
	
	public void apply(OrderUpdatedEvent event) {
		this.setState(OrderState.IN_PROCESS);
		this.setOrderTotal(event.getOrderTotal());
		this.setOrderItems(event.getOrderItems());
	}
	
	public void apply(OrderConfirmedEvent event) {
		this.setState(OrderState.APPROVED);
		orderItems.get(0).setConfirmed(true);
	}

	public void apply(ProductAddedEvent event) {

	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
