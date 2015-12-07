package com.jli.cafeunittestexample;

import java.math.BigDecimal;

/**
 * Created by johnli on 12/6/15.
 */
public class FloatUtil {
    public static float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
