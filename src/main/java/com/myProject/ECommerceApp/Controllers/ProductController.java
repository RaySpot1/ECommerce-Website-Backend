package com.myProject.ECommerceApp.Controllers;

import com.myProject.ECommerceApp.Controllers.ApiResponse.ApiResponse;
import com.myProject.ECommerceApp.Service.CategoryService;
import com.myProject.ECommerceApp.Service.ProductService;
import com.myProject.ECommerceApp.dtos.RequestDto.ProductRequestDto;
import com.myProject.ECommerceApp.model.Category;
import com.myProject.ECommerceApp.model.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> product =  productService.listProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductRequestDto productRequestDto){
        Optional<Category> optionalCategory = categoryService.readCategory(productRequestDto.getCategoryId());
        if(optionalCategory.isEmpty()){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productRequestDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody @Valid ProductRequestDto productRequestDto){
        Optional<Category> optionalCategory = categoryService.readCategory(productRequestDto.getCategoryId());
        if(optionalCategory.isEmpty()){
            return new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productId, productRequestDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Category updated Successfully"), HttpStatus.OK);
    }




}
