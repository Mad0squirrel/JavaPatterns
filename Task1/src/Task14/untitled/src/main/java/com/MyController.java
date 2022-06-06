package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.repository.BeanConfig;
import com.repository.OrderRepository;
import com.repository.model.Order;
import com.repository.model.Item;
import java.util.List;

@Controller
public class MyController {
    public static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    private OrderRepository orderRepository = context.getBean(OrderRepository.class);

    @RequestMapping("/home")
    public String getIndex() {
        return "index.html";
    }

    @RequestMapping("/orders")
    public @ResponseBody String getOrders() {
        return orderRepository.toString();
    }

    @RequestMapping("/orders/add")
    public @ResponseBody String addOrder(@RequestParam("orderDate") String orderDate) {
        if (orderDate.equals("")) {
            return "please send order date";
        }

        Order order = new Order(orderDate);

        if (orderRepository.find(order) != 0) {
            return "order with date " + orderDate + "is available";
        }

        orderRepository.add(order);

        return "order with date " + orderDate + " has been added";
    }

    @RequestMapping("/orders/delete")
    public @ResponseBody String deleteOrder(@RequestParam("orderDate") String orderDate) {
        if (orderDate.equals("")) {
            return "please send order date";
        }

        Order order = new Order(orderDate);

        if (orderRepository.find(order) == -1) {
            return "order with date " + orderDate + " is not available";
        }
        orderRepository.delete(order);
        return "order with date" + orderDate + " has been deleted";
    }

    @RequestMapping("/order")
    public @ResponseBody String findOrder(@RequestParam("orderDate") String orderDate) {
        Order order = new Order(orderDate);

        int index = orderRepository.find(order);

        if (orderRepository.find(order) == -1) {
            return "order with date " + orderDate + " is not available";
        }
        return orderRepository.getRepository().get(index).toString();
    }

    @RequestMapping("/order/addItem")
    public @ResponseBody String addItemInOrder(@RequestParam("orderDate") String orderDate, @RequestParam("name") String name,
                                               @RequestParam("creationDate") String creationDate, @RequestParam("price") Integer price) {
        Order order = new Order(orderDate);

        int index = orderRepository.find(order);

        if (orderRepository.find(order) == -1) {
            return "order with date " + orderDate + " is not available";
        }

        Order orderInRep = orderRepository.getRepository().get(index);

        if (creationDate.equals("")) {
            return "please, send date of creation";
        }

        ItemEnum itemEnum;

        try {
            itemEnum = ItemEnum.valueOf(name);
        } catch (Exception e) {
            return "please, send name of item";
        }

        if (name.equals("")) {
            return "please, send item name";
        }

        Item item = new Item(itemEnum, creationDate, price);

        if (orderInRep.findItemInOrder(item) >= 0) {
            return "item with name " + name + ", date of creation " + creationDate + " and price " + price + " is not available";
        }

        orderInRep.addItem(item);

        return "item with name " + name + ", date of creation " + creationDate + " and price " + price + " has been added";
    }

    @RequestMapping("/order/deleteItem")
    public @ResponseBody String deleteItemInOrder(@RequestParam("orderDate") String orderDate, @RequestParam("name") String name,
                                                  @RequestParam("creationDate") String creationDate, @RequestParam("price") Integer price) {
        Order order = new Order(orderDate);

        int index = orderRepository.find(order);

        if (orderRepository.find(order) == -1) {
            return "order with date " + orderDate + " is not available";
        }

        Order orderInRep = orderRepository.getRepository().get(index);

        if (creationDate.equals("")) {
            return "please send date of creation";
        }

        ItemEnum itemEnum;

        try {
            itemEnum = ItemEnum.valueOf(name);
        } catch (Exception e) {
            return "please send name of item";
        }

        if (name.equals("")) {
            return "please send name of item";
        }


        Item item = new Item(itemEnum, creationDate, price);

        if (orderInRep.findItemInOrder(item) == -1) {
            return "item with name " + name + ", date of creation " + creationDate + " and price " + price + " is not available";
        }

        orderInRep.deleteItem(item);

        return "item with name " + name + ", date of creation " + creationDate + " and price " + price + " has been deleted";
    }

}
