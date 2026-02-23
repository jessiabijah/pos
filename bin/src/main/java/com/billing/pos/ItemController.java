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
public class ItemController {

    @Autowired
    private ItemRepository repository;

    // Find
    @GetMapping("/items")
    List<Item> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Item newItem(@RequestBody Item newItems) {
        return repository.save(newItems);
    }

    // Find
    @GetMapping("/item/{id}")
    Item findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    // Save or update
    @PutMapping("/items/{id}")
    Item saveOrUpdate(@RequestBody Item newItem, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newItem.getName());
                    x.setAuthor(newItem.getAuthor());
                    x.setPrice(newItem.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    // update author only
    @PatchMapping("/items/{id}")
    Item patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

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

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
