package com.jli.cafeunittestexample.helper;

import com.jli.cafeunittestexample.DrinkImpl;

/**
 * Created by johnli on 12/6/15.
 */
public class DrinkImplHelper extends DrinkImpl {

    public DrinkImplHelper(String name, float cost, float sizeInOz) {
        super(name, cost, sizeInOz);
    }

    @Override
    public void setCost(float cost){
        super.setCost(cost);
    }
}
