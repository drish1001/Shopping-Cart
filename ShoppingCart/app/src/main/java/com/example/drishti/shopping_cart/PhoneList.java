package com.example.drishti.shopping_cart;

public class PhoneList {

    private int id;
    private String model;
    private String manufacturer;
    private Integer price;
    private int quantity;
    private String image;
    private String min;
    private String max;

    public PhoneList() {
    }
    public PhoneList(int id, String model, String manufacturer, Integer price, int quantity, String image) {

        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
