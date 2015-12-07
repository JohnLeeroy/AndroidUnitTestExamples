package com.jli.cafeunittestexample.helper;

import com.jli.cafeunittestexample.DrinkInterface;
import com.jli.cafeunittestexample.Patron;

import java.util.ArrayList;

/**
 * Created by johnli on 12/6/15.
 */
public class PatronHelper extends Patron{

    public PatronHelper(String name, float cashAmount) {
        super(name, cashAmount);
    }

    @Override
    public void setCash(float cash){
        super.setCash(cash);
    }

    public ArrayList<DrinkInterface> getDrinksInPossession() {
        return mDrinksInPossession;
    }
}
