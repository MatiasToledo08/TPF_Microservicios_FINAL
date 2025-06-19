package orders.service;

import orders.dto.OrderDTO;
import orders.model.Order;
import orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<OrderDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElseThrow();
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public OrderDTO update(Long id, OrderDTO dto) {
        Order order = repository.findById(id).orElseThrow();
        order.setCustomerName(dto.getCustomerName());
        order.setOrderDate(dto.getOrderDate());
        order.setTotalAmount(dto.getTotalAmount());
        return toDTO(repository.save(order));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private OrderDTO toDTO(Order o) {
        OrderDTO dto = new OrderDTO();
        dto.setId(o.getId());
        dto.setCustomerName(o.getCustomerName());
        dto.setOrderDate(o.getOrderDate());
        dto.setTotalAmount(o.getTotalAmount());
        return dto;
    }

    private Order toEntity(OrderDTO dto) {
        Order o = new Order();
        o.setCustomerName(dto.getCustomerName());
        o.setOrderDate(dto.getOrderDate());
        o.setTotalAmount(dto.getTotalAmount());
        return o;
    }
}
