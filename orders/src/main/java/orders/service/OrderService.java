package orders.service;

import orders.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getAll();
    OrderDTO getById(Long id);
    OrderDTO create(OrderDTO dto);
    OrderDTO update(Long id, OrderDTO dto);
    void delete(Long id);
}
