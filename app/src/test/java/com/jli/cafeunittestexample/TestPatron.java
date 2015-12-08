package com.jli.cafeunittestexample;

import com.jli.cafeunittestexample.helper.PatronHelper;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by johnli on 12/6/15.
 */
public class TestPatron {

    PatronHelper mMatt;
    Cafe mCafe;

    @Before
    public void SetUp(){
        mMatt = new PatronHelper("Matt", 100);
        mCafe = mock(Cafe.class);
    }

    @Test
    public void NameGetter() {
        assertEquals(mMatt.getName(), "Matt");
    }

    @Test
    public void CheckRoundedFloatValueAfterSetCash(){
        mMatt.setCash(3.141592f);
        assertEquals(mMatt.getCash(), 3.14f);
    }

    @Test
    public void EnterCafe(){
        mMatt.enterCafe(mCafe);
        assertEquals(mCafe, mMatt.getCurrentCafe());
    }

    @Test
    public void BuyDrinkWithEnoughMoney() throws Patron.NotEnoughMoneyException {
        //create mocked drink
        String targetDrinkName = "Nuka Cola";
        DrinkInterface nukaColaMock = getMockedDrink(targetDrinkName, 4);

        //return mock drink when sellDrink is called
        when(mCafe.getDrink(targetDrinkName)).thenReturn(nukaColaMock);
        when(mCafe.sellDrink(targetDrinkName)).thenReturn(nukaColaMock);

        mMatt.enterCafe(mCafe);
        mMatt.purchaseDrinkFromCafe(targetDrinkName);

        assertFalse(mMatt.mDrinksInPossession.isEmpty());
        assert(mMatt.mDrinksInPossession.get(0) == nukaColaMock);
    }

    @Test(expected = Patron.NotEnoughMoneyException.class)
    public void BuyDrinkWithoutEnoughMoney() throws Patron.NotEnoughMoneyException {
        //create mocked drink
        String targetDrinkName = "Nuka Cola";
        DrinkInterface nukaColaMock = getMockedDrink(targetDrinkName, 0);

        //set mock drink cost value to max
        when(nukaColaMock.getCost()).thenReturn(Float.MAX_VALUE);

        //return mock drink when a drink is a required return
        when(mCafe.getDrink(targetDrinkName)).thenReturn(nukaColaMock);
        when(mCafe.sellDrink(targetDrinkName)).thenReturn(nukaColaMock);

        mMatt.enterCafe(mCafe);
        mMatt.purchaseDrinkFromCafe(targetDrinkName);
    }

    DrinkInterface getMockedDrink(String targetDrinkName, float cost) {
        DrinkInterface nukaColaMock = mock(DrinkInterface.class);
        //set return values for properties
        when(nukaColaMock.getCost()).thenReturn(cost);
        when(nukaColaMock.getName()).thenReturn(targetDrinkName);
        return nukaColaMock;
    }
}
