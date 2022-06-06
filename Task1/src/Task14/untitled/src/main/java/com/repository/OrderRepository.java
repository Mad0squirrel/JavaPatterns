package com.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.repository.model.Order;
import com.repository.model.Item;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class OrderRepository {

    List<Order> repository = new ArrayList<>();

    public OrderRepository() {}

    public List<Order> getRepository() {
        return repository;
    }

    public void setRepository(List<Order> repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 0;

        for (Order order : repository) {
            result += order.toString() + "</br></br>";
        }
        return result;
    }

    public void add(Order order) {
        repository.add(order);
    }

    public void delete(Order order) {
        repository.removeIf(orderRep -> orderRep.getOrderDate().equals(order.getOrderDate()));
    }

    public int find(Order order) {
        int i = 0;
        for (Order orderRep : repository) {
            i++;
            if (orderRep.getOrderDate().equals(order.getOrderDate())) {
                return i;
            }
        }
        return 0;
    }
}
