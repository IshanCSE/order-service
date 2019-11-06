package ms.sample.services.orderService;

import java.util.List;

import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import ms.sample.services.inventoryService.model.ProductAddedEvent;
import ms.sample.services.orderService.commands.CreateOrderCommand;
import ms.sample.services.orderService.commands.OrderCommand;
import ms.sample.services.orderService.model.OrderCreatedEvent;
import ms.sample.services.orderService.model.OrderState;
import static io.eventuate.EventUtil.events;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order, OrderCommand> {
	private int orderTotal;
	private String customerId;
	private OrderState state;

	public List<Event> process(CreateOrderCommand cmd) {
		Product product = cmd.getProducts().get(0);
		return events(new OrderCreatedEvent(cmd.getCustomerId(), cmd.getOrderTotal()),
				new ProductAddedEvent(product.getProductId(), product.getCount()));
	}

	public void apply(OrderCreatedEvent event) {
		this.setState(OrderState.CREATED);
		this.setCustomerId(event.getCustomerId());
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

}
