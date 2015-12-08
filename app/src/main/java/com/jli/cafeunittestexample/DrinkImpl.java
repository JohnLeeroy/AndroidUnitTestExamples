package com.jli.cafeunittestexample;

import static com.jli.cafeunittestexample.FloatUtil.round;

/**
 * Created by johnli on 12/6/15.
 */
public class DrinkImpl implements DrinkInterface {

    //Members
    private String mName;
    private float mCost;
    private float mSizeInOz;

    //Constructors
    public DrinkImpl(String name, float cost, float sizeInOz) {
        mName = name;
        setCost(cost);
        mSizeInOz = sizeInOz;
    }

    public DrinkImpl(DrinkImpl other) {
        mName = other.getName();
        setCost(other.getCost());
        mSizeInOz = other.getSizeInOz();
    }

    //Protected Methods
    protected void setCost(float cost) {
        mCost = round(cost, 2);
    }

    //Public Methods
    public void drink(float ounceAmount) throws NotEnoughCoffeeException {
        if (ounceAmount > mSizeInOz) {
            throw new NotEnoughCoffeeException();
        }
        mSizeInOz -= ounceAmount;
    }

    public float getSizeInOz() {
        return mSizeInOz;
    }

    @Override
    public DrinkInterface getCopy() {
        return new DrinkImpl(this);
    }

    @Override
    public String getName() {
        return mName;
    }

    public float getCost() {
        return mCost;
    }

    //Exceptions
    public class NotEnoughCoffeeException extends Exception {
    }
}
