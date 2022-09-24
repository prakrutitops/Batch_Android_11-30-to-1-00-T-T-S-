package com.example.retrofitex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model
{
    @Expose
    @SerializedName("product_id")
    int product_id;

    @Expose
    @SerializedName("product_name")
    String product_name;

    @Expose
    @SerializedName("product_price")
    String product_price;

    @Expose
    @SerializedName("product_description")
    String product_description;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
}
