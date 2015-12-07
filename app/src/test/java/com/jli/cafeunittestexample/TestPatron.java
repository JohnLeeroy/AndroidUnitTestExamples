package com.jli.cafeunittestexample;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by johnli on 12/6/15.
 */
public class TestPatron {

    Patron mMatt;
    Cafe mCafe;
    @Before
    public void setUp(){
        mMatt = new Patron("Matt", 100);
        mCafe = mock(Cafe.class);
    }

    @Test
    public void enterCafe(){
        mMatt.enterCafe(mCafe);
        assertEquals(mCafe, mMatt.getCurrentCafe());
    }

    @Test
    public void buyDrink(){
        String targetDrinkName = "Nuka Cola";
        DrinkInterface nukaColaMock = mock(DrinkInterface.class);
        float nukaColaCost = 4f;
        when(mCafe.getDrink(targetDrinkName)).thenReturn(nukaColaMock);
        when(nukaColaMock.getCost()).thenReturn(nukaColaCost);
        when(nukaColaMock.getName()).thenReturn(targetDrinkName);
        when(mCafe.sellDrink(targetDrinkName)).thenReturn(nukaColaMock);
        mMatt.enterCafe(mCafe);
        mMatt.purchaseDrinkFromCafe(targetDrinkName);
        assert(mMatt.mDrinksInPossession.get(0) == nukaColaMock);
    }
}
