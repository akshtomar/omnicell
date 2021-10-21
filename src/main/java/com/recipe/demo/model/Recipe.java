package com.recipe.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "id")
    public long id;

    @Column(name = "name")
    public String name;

    @Column(name = "image")
    public String image;

    @Column(name = "category")
    public String category;

    @Column(name = "label")
    public String label;

    @Column(name = "price")
    public String price;

    @Column(name = "description")
    public String description;

    public Recipe() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", label='" + label + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
