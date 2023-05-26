package com.myProject.ECommerceApp.Service;

import com.myProject.ECommerceApp.dtos.RequestDto.ProductRequestDto;
import com.myProject.ECommerceApp.model.Category;
import com.myProject.ECommerceApp.model.Product;
import com.myProject.ECommerceApp.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product saveProduct(Product product){
        entityManager.persist(product);
        return product;
    }

    public void addProduct(ProductRequestDto productRequestDto, Category category){
        Product product = getProductFromDto(productRequestDto, category);
        productRepository.save(product);
    }

    public static Product getProductFromDto(ProductRequestDto productRequestDto, Category category){
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productRequestDto.getDescription());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setPrice(productRequestDto.getPrice());
        product.setName(productRequestDto.getName());
        return product;
    }

    public List<Product> listProducts(){
        //        List<ProductRequestDto> productDto = new ArrayList<>();
//        for(Product product : products){
//            productDto.add(new ProductRequestDto(product));
//        }
        return productRepository.findAll();
    }

    public void updateProduct(Integer productID, ProductRequestDto productRequestDto, Category category){
        Product product = getProductFromDto(productRequestDto, category);
        product.setId(productID);
        productRepository.save(product);
    }




}
