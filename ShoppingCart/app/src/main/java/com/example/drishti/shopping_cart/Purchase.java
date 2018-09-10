package com.example.drishti.shopping_cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Purchase {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("invoiceNumber")
    @Expose
    private String invoiceNumber;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("model")
    @Expose
    private String model;


    public Purchase(String username, String quantity, String model, String invoiceNumber) {
        super();
        this.username = username;
        this.quantity = quantity;
        this.model = model;
        this.invoiceNumber = invoiceNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getModel() {
        return model;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }
}
