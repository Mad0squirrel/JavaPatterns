package com.example.task14;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/add")
public class AddingController {
    @GetMapping("/bank/{name}")
    public String addBank(@PathVariable String name){
        Bank bank = new Bank(name);
        boolean check = Service.add(bank);
        if (check){
            System.out.println("Bank " + name + " created");
            return "Bank " + bank.getBankName() + " has been created";
        } else {
            System.out.println("Bank with this name already exists");
            return "Bank with this name already exists";
        }
    }


    @GetMapping("/{bankN}/{cardN}/{cardC}")
    public String addCard(@PathVariable String bankN, @PathVariable String cardN, @PathVariable String cardC){
        Bank bank = Service.find(bankN);
        if (bank == null){
            System.out.println("Bank " + bankN + " not found");
            return "Bank " + bankN + " not found";
        }
        Card card = new Card(cardN, cardC);
        bank.addCard(card);
        System.out.println("Card added in Bank" + bank.getBankName());
        return "Card added in Bank " + bank.getBankName();
    }
}
