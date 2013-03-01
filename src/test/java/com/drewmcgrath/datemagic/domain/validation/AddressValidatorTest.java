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
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setCity("gotham");
        address.setState("confusion");
        address.setZipcode(20165);

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertFalse(errors.containsErrors());
    }
}
