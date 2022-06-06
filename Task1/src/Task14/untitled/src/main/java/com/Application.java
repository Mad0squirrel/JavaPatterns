package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.repository.BeanConfig;
import com.repository.OrderRepository;
import com.repository.model.Order;
import com.repository.model.Item;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        OrderRepository orderRepository = MyController.context.getBean(OrderRepository.class);

        List<Order> orderList = orderRepository.getRepository();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(ItemEnum.APPLE_MACBOOK_AIR_13, "16.02.2021", 149900));
        itemList.add(new Item(ItemEnum.APPLE_MACBOOK_AIR_13, "20.09.2020", 115700));
        itemList.add(new Item(ItemEnum.APPLE_MACBOOK_AIR_13, "06.04.2021", 89500));
        orderList.add(new Order("07.05.2022", itemList));
        orderList.add(new Order("08.05.2022"));
        itemList = new ArrayList<>();
        itemList.add(new Item(ItemEnum.SAMSUNG_GALAXY_S20, "03.02.2022", 87000));
        itemList.add(new Item(ItemEnum.APPLE_IPHONE_13_PRO, "14.09.2021", 97800));
        itemList.add(new Item(ItemEnum.XIAOMI_12X, "28.03.2022", 45900));
        itemList.add(new Item(ItemEnum.APPLE_IPAD_MINI, "08.11.2021", 41300));
        orderList.add(new Order("09.05.2022", itemList));
        orderRepository.setRepository(orderList);

        SpringApplication.run(Application.class, args);
    }

}
