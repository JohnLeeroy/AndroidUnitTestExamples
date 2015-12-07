package com.jli.cafeunittestexample;

/**
 * Created by johnli on 12/6/15.
 */
public interface DrinkInterface {
    String getName();
    float getCost();
    float getSizeInOz();

    abstract DrinkInterface getCopy();
}

