package orders.ucc.product.controller;

import orders.ucc.product.model.entities.Product;
import orders.ucc.product.model.dto.ProductDTO;
import orders.ucc.product.model.dto.ProductinfoDTO;
import orders.ucc.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

@Tag(name = "Products", description = "Operaciones relacionadas con productss")
@Tag(name = "Productos", description = "Operaciones relacionadas con Operaciones relacionadas con los productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Endpoint para obtener todos los productos

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductinfoDTO> getProductsDTO() {
        return productService.getAllinfoProducts();
    }

    @GetMapping("/id")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    //End point para crear un producto

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDTO product){
        this.productService.newProduct(product);
    }


    @GetMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsPriceDesc(){
        return productService.getProductsByPriceDesc();
    }

    @GetMapping("/{id}/disponibilidad")
    public ResponseEntity<Boolean> verificarStock(@PathVariable Long id, @RequestParam int cantidad) {
        boolean disponible = productService.hasStock(id, cantidad);
        return ResponseEntity.ok(disponible);
    }


}

