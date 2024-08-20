package com.fred.apirest.com.fred.apirest.Repositories;

import com.fred.apirest.com.fred.apirest.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long > {

}
