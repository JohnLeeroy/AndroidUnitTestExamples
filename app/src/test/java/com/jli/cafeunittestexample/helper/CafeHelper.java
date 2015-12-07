package com.jli.cafeunittestexample.helper;

import com.jli.cafeunittestexample.Cafe;

/**
 * Created by johnli on 12/6/15.
 */
public class CafeHelper extends Cafe {

    public int getMenuSize(){
        return mMenu.size();
    }

    public int getCustomerCount(){
        return mCustomers.size();
    }
}
