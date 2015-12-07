package com.jli.cafeunittestexample;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by johnli on 12/6/15.
 */
public class Cafe {

    protected HashMap<String, DrinkInterface> mMenu;
    protected HashSet<Patron> mCustomers;

    public Cafe(){
        mMenu = new HashMap<>();
        mCustomers = new HashSet<>();
    }

    public void addDrinkItemToMenu(DrinkInterface drink) {
        mMenu.put(drink.getName(), drink);
    }
    public void addNewCustomer(Patron patron){
        mCustomers.add(patron);
    }

    public DrinkInterface getDrink(String name){
        return mMenu.get(name);
    }

    public Patron getCustomer(String name){
        for(Patron patron : mCustomers){
            if(patron.getName().equals(name))
                return patron;
        }
        return null;
    }

    public DrinkInterface sellDrink(String name){
        DrinkInterface newDrink = mMenu.get(name).getCopy();
        return newDrink;
    }
}
