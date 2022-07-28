package com.example.toolbarex;

public class Model
{
    int image;
    String name,price;

    Model(int image,String name,String price)
    {
        this.name=name;
        this.image=image;
        this.price=price;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
