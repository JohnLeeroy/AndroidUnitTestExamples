package com.jli.cafeunittestexample;

import java.util.ArrayList;

/**
 * Created by johnli on 12/6/15.
 */
public class Patron {

    //Members
    private String mName;

    protected float mCash;

    protected Cafe mCurrentCafe;

    protected ArrayList<DrinkInterface> mDrinksInPossession;

    //Constructor
    public Patron(String name, float cashAmount) {
        mName = name;
        setCash(cashAmount);
        mDrinksInPossession = new ArrayList<>();
    }

    //Protected Method
    protected void setCash(float cash) {
        mCash = FloatUtil.round(cash, 2);
    }

    //Public Method
    public String getName() {
        return mName;
    }

    public void enterCafe(Cafe cafe) {
        cafe.addNewCustomer(this);
        mCurrentCafe = cafe;
    }

    public Cafe getCurrentCafe() {
        return mCurrentCafe;
    }

    public void purchaseDrinkFromCafe(String drinkName) throws NotEnoughMoneyException {
        //Find Drink
        DrinkInterface drink = mCurrentCafe.getDrink(drinkName);

        //Check Cost
        float cost = drink.getCost();
        if (mCash >= cost) {
            mCash -= cost;
        } else {
            throw new NotEnoughMoneyException();
        }

        DrinkInterface newDrink = mCurrentCafe.sellDrink(drink.getName());
        mDrinksInPossession.add(newDrink);
    }

    //Exception
    public class NotEnoughMoneyException extends Exception {
    }
}
