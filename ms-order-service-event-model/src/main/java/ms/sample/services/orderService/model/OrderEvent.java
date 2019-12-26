package ms.sample.services.orderService.model;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "ms.sample.services.orderService.Order")
public interface OrderEvent extends Event {
}