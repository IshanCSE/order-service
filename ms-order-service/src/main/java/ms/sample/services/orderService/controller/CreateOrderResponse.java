package ms.sample.services.orderService.controller;

public class CreateOrderResponse {
	private String orderId;

	public CreateOrderResponse() {
	}

	public CreateOrderResponse(String orderId) {
		this.orderId = orderId;

	}

	public String getOrderId() {
		return orderId;
	}
}