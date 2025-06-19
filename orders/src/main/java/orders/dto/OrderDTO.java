package orders.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private Long id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String customerName;

    @NotNull(message = "La fecha del pedido es obligatoria")
    private LocalDate orderDate;

    @NotNull(message = "El monto total es obligatorio")
    @PositiveOrZero(message = "El monto debe ser mayor o igual a 0")
    private Double totalAmount;
}
