package com.jli.cafeunittestexample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by johnli on 12/6/15.
 */
public class Cafe {

    //Members
    protected Map<String, DrinkInterface> mMenu;
    protected Set<Patron> mCustomers;

    //Constructor
    public Cafe() {
        mMenu = new HashMap<>();
        mCustomers = new HashSet<>();
    }

    //Public Methods
    public void addDrinkItemToMenu(DrinkInterface drink) {
        mMenu.put(drink.getName(), drink);
    }

    public boolean addNewCustomer(Patron patron) {
        return mCustomers.add(patron);
    }

    public DrinkInterface getDrink(String name) {
        DrinkInterface drink = mMenu.get(name);
        return drink;
    }

    public Patron getCustomer(String name) {
        for (Patron patron : mCustomers) {
            if (patron.getName().equals(name))
                return patron;
        }
        return null;
    }

    public DrinkInterface sellDrink(String name) {
        DrinkInterface newDrink = getDrink(name).getCopy();
        return newDrink;
    }
}
