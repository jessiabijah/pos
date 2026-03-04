package com.billing.pos;

import com.billing.pos.error.ItemNotFoundException;
import com.billing.pos.error.ItemUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

	@Autowired
    private ProductRepository repository;

 // Find
@GetMapping("/product")
List<Product> findAll() {
    return repository.findAll();
}

// Save
@PostMapping("/products")
//return 201 instead of 200

Product newItem(@RequestBody Product newItems) {
    return repository.save(newItems);
}

// Find
@GetMapping("/product/{id}")
Product findOne(@PathVariable int id) {
    return repository.findById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
}

// Save or update
@PutMapping("/product/{id}")
Product saveOrUpdate(@RequestBody Product newItem, @PathVariable int id) {

    return repository.findById(id)
            .map(x -> {
            	x.setName(newItem.getName());
    			x.setPrice(newItem.getPrice());
    			x.setQuantity(newItem.getQuantity());
    			x.setDiscount(newItem.getDiscount());
    			x.setDescritpion(newItem.getDescritpion());
    			x.setCategory(newItem.getCategory());
                return repository.save(x);
            })
            .orElseGet(() -> {
                newItem.setId(id);
                return repository.save(newItem);
            });
}

// update author only
@PatchMapping("/product/{id}")
Product patch(@RequestBody Map<String, String> update, @PathVariable int id) {

    return repository.findById(id)
            .map(x -> {

                String name = update.get("name");
                if (!StringUtils.isEmpty(name)) {
                    x.setName(name);

                    // better create a custom method to update a value = :newValue where id = :id
                    return repository.save(x);
                } else {
                    throw new ItemUnSupportedFieldPatchException(update.keySet());
                }

            })
            .orElseGet(() -> {
                throw new ItemNotFoundException(id);
            });

}

@DeleteMapping("/product/{id}")
String deleteItem(@PathVariable int id) {
    repository.deleteById(id);
	return "deleted succesfully";


}
}