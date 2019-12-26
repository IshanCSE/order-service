package ms.sample.services.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import ms.sample.services.orderService.Order;
import ms.sample.services.orderService.OrderService;

@RestController
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
		System.out.println("Order request received ............. " + createOrderRequest.getOrderItems().size());
		EntityWithIdAndVersion<Order> order = orderService.createOrder(createOrderRequest.getCustomerId(),
				createOrderRequest.getOrderTotal(), createOrderRequest.getOrderItems());
		return new ResponseEntity<>(new CreateOrderResponse(order.getEntityId()), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDetailResponse> getOrderDetails(@PathVariable("id") String orderId) {
		System.out.println("Get Order request received ............. " + orderId);
		EntityWithMetadata<Order> order = orderService.getOrderEntity(orderId);
		return new ResponseEntity<>(new OrderDetailResponse(order.getEntity()), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CreateOrderResponse> getOrderDetails(@PathVariable("id") String orderId,
			@RequestBody UpdateOrderRequest updateOrderRequest) {
		System.out.println("Put Order request received ............. " + orderId);
		EntityWithIdAndVersion<Order> order = orderService.updateOrder(orderId, updateOrderRequest.getOrderTotal(),
				updateOrderRequest.getOrderItems());
		return new ResponseEntity<>(new CreateOrderResponse(order.getEntityId()), HttpStatus.OK);
	}
}