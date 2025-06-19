package orders.ucc.product.model.dto;

import orders.ucc.product.model.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductinfoDTO implements Serializable {
    private long id;
    private String name;
    private CategoryInfoDTO categoryInfoDTO;

    public ProductinfoDTO(long id, String name, Category category) {
        this.id = id;
        this.name = name;
        if (category != null) {
            CategoryInfoDTO categoryInfoDTOAUX = new CategoryInfoDTO();
            categoryInfoDTOAUX.setName(category.getName());
            categoryInfoDTOAUX.setStatus(category.getStatus());
            this.categoryInfoDTO = categoryInfoDTOAUX;
        }
    }
}