package orders.ucc.product.service;

import orders.ucc.product.exceptions.Product.ProductNotExistException;
import orders.ucc.product.model.entities.Product;
import orders.ucc.product.model.dto.ProductDTO;
import orders.ucc.product.model.dto.ProductinfoDTO;
import orders.ucc.product.model.mappers.ProductsMapper;
import orders.ucc.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository; //Estamos inyectado el repositorio en nuestro servicio
    private final ProductsMapper productsMapper;

    //Metodo que obtenga todos los productos guardados

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductinfoDTO> getAllinfoProducts() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new ProductinfoDTO(productEntity.getId(), productEntity.getName(), productEntity.getCategory()))
                .collect(Collectors.toList());
    }

    public Product getProductById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotExistException("No se encuentra el producto con el id indicado" + id);
        }else{
            return productOptional.get();
        }
    }
    //Metodo que crea un producto (sin Mapper)

    /*public void createProduct(ProductDTO productDTO){
        Product productEntity = new Product();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStatus(Boolean.TRUE);
        productRepository.save(productEntity);
    }*/

    //Metodo que crea un producto (con Mapper)

    public void newProduct(ProductDTO productDTO){
        Product productEntity = productsMapper.productsDTOToProductsEntity(productDTO);
        productRepository.save(productEntity);
        new ResponseEntity<>(HttpStatus.CREATED);
    }


    public List<Product> getProductsByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    public boolean hasStock(Long id, int cantidad) {
        Optional<Product> productOpt = productRepository.findById(id);
        return productOpt.map(p -> p.getStock() >= cantidad).orElse(false);
    }


}
