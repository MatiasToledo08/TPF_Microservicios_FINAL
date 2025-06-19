package orders.ucc.product.controller;

import orders.ucc.product.model.entities.Category;
import orders.ucc.product.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Operaciones relacionadas con categoriess")
@Tag(name = "Categorías", description = "Operaciones relacionadas con Operaciones relacionadas con las categorías")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addCategories(@RequestBody Category category){
        this.categoryService.newCategory(category);
    }
}
