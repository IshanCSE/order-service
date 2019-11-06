package ms.sample.services.orderService.configuration;


import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import ms.sample.services.orderService.Order;
import ms.sample.services.orderService.OrderService;
import ms.sample.services.orderService.OrderServiceImpl;
import ms.sample.services.orderService.commands.OrderCommand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableEventHandlers
public class OrderBackendConfiguration {

	@Bean
	public OrderService orderService(AggregateRepository<Order, OrderCommand> orderRepository) {
		return new OrderServiceImpl(orderRepository);
	}

	@Bean
	public AggregateRepository<Order, OrderCommand> orderRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(Order.class, eventStore);
	}
}
