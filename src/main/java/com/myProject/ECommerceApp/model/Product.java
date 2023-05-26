package com.myProject.ECommerceApp.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private @NotNull String name;

    private @NotNull String imageUrl;

    private @NotNull double price;

    private @NotNull String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;


//    public Product() {
//
//    }

    public Product(@NotNull String name, @NotNull double price, @NotNull String description, @NotNull Category category){
        this.name = name;
        this. price = price;
        this.description = description;
        this.category = category;
    }

    @NotNull
    public Product(String name, String imageUrl, double price, String description, Category category) {
        super();
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.category = category;
    }

//    public Product create(String name, double price, String description, Category category){
//        Product product = new Product();
//        product.setName(name);
//        product.setPrice(price);
//        product.setDescription(description);
//        product.setCategory(category);
//
//        sessionFactory.getCurrentSession().persist(product)
//
//    }


    @Override
    public String toString() {
        return "Product {Id=" + Id + ", name = '" + name + "',imageUrl ='"+ imageUrl +"', price = '" + price + "', description='" + description + "', category = '"+ category +"'}";
    }
}
