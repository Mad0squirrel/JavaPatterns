package com.example.task14;

import java.util.ArrayList;
import java.util.Objects;

public class Service {
    public static ArrayList<Bank> banks = new ArrayList<>();

    public static boolean delete(String name){
        if (banks == null)
            return false;
        for (Bank bank : banks){
            if (Objects.equals(bank.getBankName(), name)){
                banks.remove(bank);
                return true;
            }
        }
        return false;
    }

    public static boolean add(Bank temp){
        if (banks == null){
            banks.add(temp);
            return true;
        }
        for (Bank group : banks){
            if (Objects.equals(group.getBankName(), temp.getBankName())){
                return false;
            }
        }
        banks.add(temp);
        return true;
    }

    public static Bank find(String name){
        if (banks == null)
            return null;
        for (Bank group : banks){
            if (Objects.equals(group.getBankName(), name)){
                return group;
            }
        }
        return null;
    }
}
