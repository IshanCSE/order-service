package ms.sample.services.orderService.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class OrderCreatedEvent implements OrderEvent {
  private int orderTotal;
  private String customerId;

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  public OrderCreatedEvent() {
  }

  public OrderCreatedEvent(String customerId, int orderTotal) {
    this.customerId = customerId;
    this.orderTotal = orderTotal;
  }

  public int getOrderTotal() {
    return orderTotal;
  }

  public String getCustomerId() {
    return customerId;
  }
}