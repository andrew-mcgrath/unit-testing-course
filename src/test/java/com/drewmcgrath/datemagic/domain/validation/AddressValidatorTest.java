/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Address;
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
public class AddressValidatorTest {

    public AddressValidatorTest() {
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

    /**
     * Test of isAddressComplete method, of class AddressValidator.
     */
    @Test
    public void testIsAddressComplete() {
        System.out.println("isAddressComplete");
        Address address = null;
        AddressValidator instance = new AddressValidator();
        Errors expResult = null;
        Errors result = instance.isAddressComplete(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
