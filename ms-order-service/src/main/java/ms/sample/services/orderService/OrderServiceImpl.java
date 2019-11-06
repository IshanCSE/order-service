package ms.sample.services.orderService;

import io.eventuate.sync.AggregateRepository;
import ms.sample.services.orderService.commands.CreateOrderCommand;
import ms.sample.services.orderService.commands.OrderCommand;

import java.util.List;

import io.eventuate.EntityWithIdAndVersion;

public class OrderServiceImpl implements OrderService {

	private final AggregateRepository<Order, OrderCommand> orderRepository;

	public OrderServiceImpl(AggregateRepository<Order, OrderCommand> orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public EntityWithIdAndVersion<Order> createOrder(String customerId, int orderTotal, List<Product> products) {
		System.out.println("Create order request received");
		return  orderRepository.save(new CreateOrderCommand(customerId, orderTotal, products));
	}

}
