package ms.sample.services.orderService.controller;

import ms.sample.services.orderService.model.OrderState;

public class UpdateOrderResponse {
	private String orderId;
	private OrderState state;

	public UpdateOrderResponse(String orderId, OrderState state) {
		super();
		this.orderId = orderId;
		this.state = state;
	}

	public String getOrderId() {
		return orderId;
	}

	public OrderState getState() {
		return state;
	}

}
