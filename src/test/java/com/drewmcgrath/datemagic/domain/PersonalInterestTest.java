/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amcgrath
 */
public class PersonalInterestTest {

    public PersonalInterestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

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
}
