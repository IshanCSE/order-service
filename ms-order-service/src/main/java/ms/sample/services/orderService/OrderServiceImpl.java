package ms.sample.services.orderService;

import io.eventuate.sync.AggregateRepository;
import ms.sample.services.orderService.commands.CreateOrderCommand;
import ms.sample.services.orderService.commands.OrderCommand;
import ms.sample.services.orderService.model.OrderItem;

import java.util.List;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public class OrderServiceImpl implements OrderService {

	private final AggregateRepository<Order, OrderCommand> orderRepository;

	public OrderServiceImpl(AggregateRepository<Order, OrderCommand> orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public EntityWithIdAndVersion<Order> createOrder(String customerId, int orderTotal, List<OrderItem> orderItems) {
		System.out.println("Create order request received");
		return  orderRepository.save(new CreateOrderCommand(customerId, orderTotal, orderItems));
	}

	@Override
	public EntityWithMetadata<Order> getOrderEntity(String orderId) {
		System.out.println("Order detail request");
		return orderRepository.find(orderId);
	}

	@Override
	public EntityWithIdAndVersion<Order> updateOrder(String orderId, int orderTotal, List<OrderItem> products) {
		System.out.println("Order update request");
		return  orderRepository.save(new CreateOrderCommand("", orderTotal, products));
	
	}

}
