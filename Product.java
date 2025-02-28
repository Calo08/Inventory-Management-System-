package model;

import javafx.beans.property.*;

public class Product {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty category;
    private DoubleProperty price;
    private IntegerProperty stock;

    public Product(int id, String name, String category, double price, int stock) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }

    public Product(String name, String category, double price, int stock) {
        this(0, name, category, price, stock);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getCategory() {
        return category.get();
    }

    public double getPrice() {
        return price.get();
    }

    public int getStock() {
        return stock.get();
    }

    // Setters and getters for properties

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }
}
