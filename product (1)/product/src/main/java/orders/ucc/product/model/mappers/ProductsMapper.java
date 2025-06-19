package orders.ucc.product.model.mappers;

import orders.ucc.product.model.entities.Category;
import orders.ucc.product.model.entities.Product;
import orders.ucc.product.model.dto.ProductDTO;
import orders.ucc.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductsMapper {

    private final CategoryRepository categoryRepository;
    public Product productsDTOToProductsEntity(ProductDTO productDTO){
        Product productEntity = new Product();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStatus(Boolean.TRUE);

        Category categoryEntity = categoryRepository.findOneById(productDTO.getCategoryDTO().getId());
        productEntity.setCategory(categoryEntity);
        return productEntity;
    }

    public ProductDTO productEntityToProductDTO(Product productEntity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(productEntity.getName());
        productDTO.setPrice(productEntity.getPrice());
        return productDTO;
    }
}
