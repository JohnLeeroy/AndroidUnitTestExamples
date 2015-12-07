package com.jli.cafeunittestexample;

import com.jli.cafeunittestexample.helper.DrinkImplHelper;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class TestCoffee {

    static final String sCoffeeName = "Cup O' Joe";
    DrinkImplHelper mCupOfJoe;

    @Before
    public void SetUp(){
        mCupOfJoe = new DrinkImplHelper(sCoffeeName, 2.25f, 16f);
    }

    @Test
    public void DrinkCoffee(){
        float originalAmount = mCupOfJoe.getSizeInOz();
        float drinkingAmount = 6f;
        float expectedAmount = originalAmount - drinkingAmount;
        try {
            mCupOfJoe.drink(drinkingAmount);
        } catch (DrinkImpl.NotEnoughCoffeeException e) {
            e.printStackTrace();
        }
        assertEquals(mCupOfJoe.getSizeInOz(), expectedAmount);
    }

    @Test(expected = DrinkImpl.NotEnoughCoffeeException.class)
    public void OverDrinkCoffee() throws DrinkImpl.NotEnoughCoffeeException {
        float originalAmount = mCupOfJoe.getSizeInOz();
        float drinkingAmount = originalAmount + 1f;
        mCupOfJoe.drink(drinkingAmount);
    }

    @Test
    public void CheckRoundedValueAfterSetCost(){
        float cost = 3.141592f;
        mCupOfJoe.setCost(cost);
        assertEquals(3.14f, mCupOfJoe.getCost());
    }

    @Test
    public void CheckName(){
        assertEquals(sCoffeeName, mCupOfJoe.getName());
    }

    @Test
    public void VerifyCopyConstructor(){
        DrinkInterface copy = mCupOfJoe.getCopy();
        assertEquals(copy.getName(), mCupOfJoe.getName());
        assertEquals(copy.getCost(), mCupOfJoe.getCost());
        assertEquals(copy.getSizeInOz(), mCupOfJoe.getSizeInOz());
        assertNotSame(copy, mCupOfJoe); //check if not the same reference
    }
}
