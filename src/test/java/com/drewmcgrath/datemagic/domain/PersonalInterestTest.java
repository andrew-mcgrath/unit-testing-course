/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author amcgrath
 */
@RunWith(value = Parameterized.class)
public class PersonalInterestTest {

    //<editor-fold defaultstate="collapsed" desc="parameterized">
    private String input;
    private PersonalInterest expectedResult;

    public PersonalInterestTest(String input, PersonalInterest output) {
        this.input = input;
        this.expectedResult = output;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
            {null, null},
            {"nothing that matches", null},
            {"Dancing", PersonalInterest.DANCING},
            {"Dining", PersonalInterest.DINING},
            {"Underwater Basket Weaving", PersonalInterest.UNDER_WATER_BASKET_WEAVING},
            {"DaNcInG", PersonalInterest.DANCING},
            {"DiNing", PersonalInterest.DINING},
            {"UnderWater BasKet WeaVing", PersonalInterest.UNDER_WATER_BASKET_WEAVING}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testAll() throws Exception {
        System.out.println("all");

        PersonalInterest actualResult = PersonalInterest.fromDisplayText(this.input);
        assertEquals(actualResult, this.expectedResult);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Not Parameterized">
    @Test
    public void testFromDisplayTextNull() {
        System.out.println("fromDisplayTextNull");

        // null pass
        String text = null;
        PersonalInterest result = PersonalInterest.fromDisplayText(text);
        assertNull(result);

        // invalid match
        text = "nothing that matches";
        result = PersonalInterest.fromDisplayText(text);
        assertNull(result);
    }

    @Test
    public void testFromDisplayText() throws Exception {
        System.out.println("fromDisplayText");

        // dancing
        String text = "Dancing";
        PersonalInterest result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.DANCING, result);

        // dinning
        text = "Dining";
        result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.DINING, result);

        text = "Underwater Basket Weaving";
        result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.UNDER_WATER_BASKET_WEAVING, result);
    }

    @Test
    public void testFromDisplayTextIgnoreCase() throws Exception {
        System.out.println("fromDisplayTextIgnoreCase");

        // dancing
        String text = "DaNcInG";
        PersonalInterest result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.DANCING, result);

        text = "DiNinG";
        result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.DINING, result);

        text = "UnderWater BasKet WeaVing";
        result = PersonalInterest.fromDisplayText(text);
        assertEquals(PersonalInterest.UNDER_WATER_BASKET_WEAVING, result);
    }
    //</editor-fold>
}
