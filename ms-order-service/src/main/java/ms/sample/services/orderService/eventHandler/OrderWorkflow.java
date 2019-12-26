package ms.sample.services.orderService.eventHandler;

import java.util.concurrent.CompletableFuture;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import ms.sample.services.inventoryService.model.ProductAddedEvent;
import ms.sample.services.orderService.Order;
import ms.sample.services.orderService.commands.OrderConfirmedCommand;

@EventSubscriber(id = "orderWorkflow")
public class OrderWorkflow {
	@EventHandlerMethod
	public CompletableFuture<EntityWithIdAndVersion<Order>> handleProductAdded(
			EventHandlerContext<ProductAddedEvent> ctx) {
		System.out.println("In Handle Product ..............");
		System.out.println("Event received for order ..... " + ctx.getEvent().getOrderId());

		return ctx.update(Order.class, ctx.getEvent().getOrderId(), new OrderConfirmedCommand());
	}
}
