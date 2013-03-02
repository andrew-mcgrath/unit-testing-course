/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Address;
import java.util.List;
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
    public void testIsAddressCompleteTrue() {
        System.out.println("isAddressCompleteTrue");
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setCity("gotham");
        address.setState("confusion");
        address.setZipcode("20165");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertFalse(errors.containsErrors());
    }

    @Test
    public void testIsAddressCompleteNull() throws Exception {
        System.out.println("isAddressCompleteNull");
        // create address
        Address address = null;

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(1, errorList.size());
        assertEquals("address.null", errorList.get(0).getField());
    }

    @Test
    public void testIsAddressCompleteStreetMissing() throws Exception {
        System.out.println("isAddressCompleteFalse");
        // create address
        Address address = new Address();
        address.setCity("gotham");
        address.setState("confusion");
        address.setZipcode("20165");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(1, errorList.size());
        assertEquals("address.street", errorList.get(0).getField());
    }

    @Test
    public void testIsAddressCompleteCityMissing() throws Exception {
        System.out.println("isAddressCompleteCityMissing");
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setState("confusion");
        address.setZipcode("20165");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(1, errorList.size());
        assertEquals("address.city", errorList.get(0).getField());
    }

    @Test
    public void testIsAddressCompleteStateMissing() throws Exception {
        System.out.println("isAddressCompleteStateMissing");
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setCity("gotham");
        address.setZipcode("20165");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(1, errorList.size());
        assertEquals("address.state", errorList.get(0).getField());
    }

    @Test
    public void testIsAddressCompleteZipcodeMissing() throws Exception {
        System.out.println("isAddressCompleteZipcodeMissing");
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setCity("gotham");
        address.setState("confusion");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(1, errorList.size());
        assertEquals("address.zipcode", errorList.get(0).getField());
    }

    @Test
    public void testIsAddressCompleteMultipleMissing() throws Exception {
        System.out.println("isAddressCompleteMutlipleMissing");
        // create address
        Address address = new Address();
        address.setStreet("123 fake street");
        address.setCity("gotham");

        // invoke
        AddressValidator instance = new AddressValidator();
        Errors errors = instance.isAddressComplete(address);

        // verify
        assertTrue(errors.containsErrors());
        List<ValidationError> errorList = errors.getErrors();
        assertEquals(2, errorList.size());
        assertEquals("address.state", errorList.get(0).getField());
        assertEquals("address.zipcode", errorList.get(1).getField());
    }
}
