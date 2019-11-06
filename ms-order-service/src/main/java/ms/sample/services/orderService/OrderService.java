package ms.sample.services.orderService;

import java.util.List;

import io.eventuate.EntityWithIdAndVersion;

public interface OrderService {

    EntityWithIdAndVersion<Order> createOrder(String customerId, int orderTotal, List<Product> products);
}
