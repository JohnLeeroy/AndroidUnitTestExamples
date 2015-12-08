package com.jli.cafeunittestexample;

import com.jli.cafeunittestexample.helper.CafeHelper;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

/**
 * Created by johnli on 12/6/15.
 */

/**
 * This is an example of using constructed objects to test the Cafe class.
 * We could have also mocked DrinkImpl and Patron instead of creating specific instances
 *  but the classes are so simple that it would be faster to test with real objects than
 *  mocking & stubbing.
 */
public class TestCafe {
    CafeHelper mCafeHelper;
    DrinkImpl mCoffee;
    DrinkImpl mCola;

    Patron mCurie;
    Patron mNora;

    @Before
    public void SetUp(){
        mCafeHelper = new CafeHelper();
        mCoffee = new DrinkImpl("Coffee", 2.25f, 16f);
        mCola = new DrinkImpl("Nuka Cola", 4f, 12f);
        mCurie =  new Patron("Curie", 100f);
        mNora = new Patron("Nora", 125f);
    }

    @Test
    public void AddDrink() {
        mCafeHelper.addDrinkItemToMenu(mCola);
        mCafeHelper.addDrinkItemToMenu(mCoffee);
        assertEquals(mCafeHelper.getDrink("Coffee"), mCoffee);
        assertEquals(mCafeHelper.getDrink("Nuka Cola"), mCola);
    }

    @Test
    public void AddCustomer(){
        assertTrue(mCafeHelper.addNewCustomer(mCurie));
        assertTrue(mCafeHelper.addNewCustomer(mNora));
    }

    @Test
    public void SellDrink() {
        mCafeHelper.addDrinkItemToMenu(mCola);

        DrinkInterface drink = mCafeHelper.sellDrink(mCola.getName());
        assertEquals(drink.getName(), mCola.getName());
        assertEquals(drink.getCost(), mCola.getCost());
        assertEquals(drink.getSizeInOz(), mCola.getSizeInOz());
        assertNotSame(drink, mCola);
    }

    @Test
    public void CantAddDuplicateDrinks(){
        mCafeHelper.addDrinkItemToMenu(mCoffee);
        mCafeHelper.addDrinkItemToMenu(mCoffee);
        mCafeHelper.addDrinkItemToMenu(mCola);
        assert (mCafeHelper.getMenuSize() == 2);
    }

    @Test
    public void CantAddDuplicateCustomers(){
        assertTrue(mCafeHelper.addNewCustomer(mCurie));
        assertFalse(mCafeHelper.addNewCustomer(mCurie));
        assertTrue(mCafeHelper.addNewCustomer(mNora));
        assert (mCafeHelper.getCustomerCount() == 2);
    }

    @Test
    public void FindExistingDrink(){
        mCafeHelper.addDrinkItemToMenu(mCola);
        assertNotNull(mCafeHelper.getDrink("Nuka Cola"));
    }

    @Test
    public void FindNonExistingDrink() {
        assertNull(mCafeHelper.getDrink("NonExistingDrink"));
    }

    @Test
    public void FindExistingCustomer(){
        mCafeHelper.addNewCustomer(mCurie);
        assertNotNull(mCafeHelper.getCustomer("Curie"));
    }

    @Test
    public void FindNonExistingCustomer(){
        assertNull(mCafeHelper.getCustomer("Cthulu"));
    }
}