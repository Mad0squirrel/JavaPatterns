package com.repository.model;

import com.ItemEnum;
import java.lang.Integer;

public class Item {

    private ItemEnum name;
    private String creationDate;
    private Integer price;

    public Item(ItemEnum name, String creationDate, Integer price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    public ItemEnum getName() {
        return name;
    }

    public void setName(ItemEnum name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
