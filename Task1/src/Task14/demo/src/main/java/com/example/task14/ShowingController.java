package com.example.task14;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowingController {
    @GetMapping("/all")
    public String addBank(){
        System.out.println("All banks show");
        return Service.banks.toString();
    }

    @GetMapping("/{nameU}")
    public String addCard(@PathVariable String nameU){
        Bank bank = Service.find(nameU);
        if (bank == null){
            System.out.println("Bank " + nameU + " not found");
            return "Bank" + nameU + " not found";
        }
        System.out.println("Bank " + bank.getBankName() + " show");
        return bank.toString();
    }
}