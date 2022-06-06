package com.example.task14;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//http://localhost:8080/remove/all
@RestController
@RequestMapping("/remove")
public class RemovingController {
    @GetMapping("/all")
    public String addGroup(){
        Service.banks = new ArrayList<>();
        System.out.println("All banks removed");
        return "All banks removed";
    }

    @GetMapping("/{nameB}")
    public String addStudent(@PathVariable String nameB){
        boolean check = Service.delete(nameB);
        if (check){
            System.out.println("Bank " + nameB + " has been removed");
            return "Bank " + nameB + " has been removed";
        } else {
            System.out.println("Bank with name " + nameB + " not found");
            return "Bank with name " + nameB + " not found";
        }
    }
}
