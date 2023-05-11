package com.myProject.ECommerceApp.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    public Category() {

    }

    @NotBlank
    public Category(@NotBlank String categoryName, @NotBlank String description) {
        this.categoryName = categoryName;
        this.description = description;
    }


    @NotBlank
    public Category(String categoryName, String description, String imageUrl){
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;

    }

    public String getCategoryName(){
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "User {category id=" + id + ", category name = '" + categoryName + "', description='" + description + "'}";
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
