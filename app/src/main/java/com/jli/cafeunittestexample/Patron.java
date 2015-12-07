package com.jli.cafeunittestexample;

import java.util.ArrayList;

/**
 * Created by johnli on 12/6/15.
 */
public class Patron {

    private String mName;

    private float mCash;

    protected Cafe mCurrentCafe;

    protected ArrayList<DrinkInterface> mDrinksInPossession;

    public Patron(String name, float cashAmount){
        mName = name;
        setCash(cashAmount);
        mDrinksInPossession = new ArrayList<>();
    }

    protected void setCash(float cash){
        mCash = FloatUtil.round(cash, 2);
    }

    public String getName() {
        return mName;
    }

    public void enterCafe(Cafe cafe){
        cafe.addNewCustomer(this);
        mCurrentCafe = cafe;
    }

    public Cafe getCurrentCafe() {
        return mCurrentCafe;
    }

    public void purchaseDrinkFromCafe(String drinkName){
        DrinkInterface drink = mCurrentCafe.getDrink(drinkName);
        float cost = drink.getCost();
        if(mCash >= cost){
            mCash -= cost;
        }
        DrinkInterface newDrink = mCurrentCafe.sellDrink(drink.getName());
        mDrinksInPossession.add(newDrink);
    }
}
