package orders.ucc.product.service;

import orders.ucc.product.model.entities.Category;
import orders.ucc.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void newCategory(Category category){
        categoryRepository.save(category);
        new ResponseEntity<>(HttpStatus.CREATED);
    }

}
