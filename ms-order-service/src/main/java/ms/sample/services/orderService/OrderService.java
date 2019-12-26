package ms.sample.services.orderService;

import java.util.List;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import ms.sample.services.orderService.model.OrderItem;

public interface OrderService {

    EntityWithIdAndVersion<Order> createOrder(String customerId, int orderTotal, List<OrderItem> products);
    EntityWithMetadata<Order> getOrderEntity(String orderId);
    EntityWithIdAndVersion<Order> updateOrder(String orderId, int orderTotal, List<OrderItem> products);
}
