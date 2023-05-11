//package com.myProject.ECommerceApp.Service;
//
//import com.myProject.ECommerceApp.model.Category;
//import com.myProject.ECommerceApp.repository.CategoryRepository;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@NoArgsConstructor
//@Validated
//@Repository
//public class CategoryServiceImpl implements CategoryService{
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public List<Category> listCategories() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public void createCategory(Category category) {
//        categoryRepository.save(category);
//    }
//
//    @Override
//    public Category readCategory(String categoryName) {
//        return categoryRepository.findByCategoryName(categoryName);
//    }
//
//    @Override
//    public Optional<Category> readCategory(Integer categoryId) {
//        return categoryRepository.findById(categoryId);
//    }
//
//    @Override
//    public void updateCategory(Integer categoryId, Category newCategory) {
//        Category updateCategory = categoryRepository.findById(categoryId).get();
//        updateCategory.setCategoryName(newCategory.getCategoryName());
//        updateCategory.setDescription(newCategory.getDescription());
//        updateCategory.setImageUrl(newCategory.getImageUrl());
//    }
//}
