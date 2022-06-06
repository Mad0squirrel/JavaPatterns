package com.repository.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderDate;
    private List<Item> itemList;

    public Order(String orderDate) {
        this.orderDate = orderDate;
        this.itemList = new ArrayList<>();
    }

    public Order(String orderDate, List<Item> itemList) {
        this.orderDate = orderDate;
        this.itemList = itemList;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item newItem) {
        itemList.add(newItem);
    }

    public void deleteItem(Item item) {
        itemList.removeIf(itemOrder -> itemOrder.getName().equals(item.getName()) && itemOrder.getCreationDate().equals(item.getCreationDate()));
    }

    public int findItemInOrder(Item item) {
        int i = 0;
        for (Item itemInOrder : itemList) {
            i++;
            if (itemInOrder.getName().equals(item.getName()) && itemInOrder.getCreationDate().equals(item.getCreationDate())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";

        result += orderDate + " itemNumber:" + itemList.size();
        if (itemList != null && itemList.size() != 0) {
            result += "</br>";
            for (int i = 0; i < itemList.size(); i++) {
                result += (i + 1) + ". " + itemList.get(i).getName() + " c: " + itemList.get(i).getCreationDate() + " c: " + itemList.get(i).getPrice();

                if (i != itemList.size() - 1) {
                    result += "</br>";
                }
            }
        }

        return result;
    }
}
