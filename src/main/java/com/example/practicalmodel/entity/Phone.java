package com.example.practicalmodel.entity;

import com.example.practicalmodel.entity.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Phone extends BaseEntity {
    public int id;
    public String name;
    public String brand;
    public double price;
    public String description;
    private HashMap<String, String> errors;

    public Phone() {
        errors = new HashMap<>();
        this.name = "";
        this.brand = "";
        this.description = "";
        this.price = 0.0;
    }

    public Phone(String name, String brand, double price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        errors = new HashMap<>();
    }

    public Phone(int id, String name, String brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        errors = new HashMap<>();
    }

    public Phone( int id, String name, String brand, double price, String description, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        errors = new HashMap<>();
    }

    public int getId() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public HashMap<String, String> getErrors() {
        return errors;
    }
    public boolean isValid() {return this.checkValid();}

    public boolean checkValid() {
        if(name == "" || name == null) {
            errors.put("name", "Please enter name");
        }
        if(price == 0) {
            errors.put("price", "Please enter price");
        }
        if(brand == "" || brand == null) {
            errors.put("brand", "Please enter brand");
        }
        return errors.size() == 0;
    }
}
