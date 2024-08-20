package com.fred.apirest.com.fred.apirest.Controllers;

import com.fred.apirest.com.fred.apirest.Entities.Product;
import com.fred.apirest.com.fred.apirest.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No founded product with ID: " + id));

    }
    @PutMapping("/{id}")
    public  Product updateProduct(@PathVariable Long id,@RequestBody Product productupdating){
        Product productexisting = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No founded product with id: " + id));

        productexisting .setName(productupdating.getName());
        productexisting .setPrice(productupdating.getPrice());
        return  productRepository.save(productexisting );
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No founded product with ID: " + id));

        productRepository.delete(product);
        return "The product with ID: " + id + " was deleted correctly";
    }

}
