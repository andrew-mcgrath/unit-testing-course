/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

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
public class ErrorsTest {

    public ErrorsTest() {
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
    public void testGetErrors() throws Exception {
        System.out.println("getErrors");
        Errors errors = new Errors();
        assertNotNull(errors.getErrors());
        assertTrue(errors.getErrors().isEmpty());
    }

    /**
     * Test of containsErrors method, of class Errors.
     */
    @Test
    public void testContainsErrors() {
        System.out.println("containsErrors");

        // no errors
        Errors errors = new Errors();
        assertFalse(errors.containsErrors());

        // errors exist
        errors.add(new ValidationError());
        assertTrue("Errors contained at least one error but returned that it didn't have any", errors.containsErrors());
    }

    /**
     * Test of add method, of class Errors.
     */
    @Test
    public void testAdd_Errors() {
        System.out.println("addAll");
        // other errors
        Errors otherErrors = new Errors();
        otherErrors.add(new ValidationError());
        otherErrors.add(new ValidationError());
        // errors
        Errors errors = new Errors();

        // validate that we have no errors currently
        assertTrue(errors.getErrors().isEmpty());

        // add the other errors
        errors.add(otherErrors);
        assertFalse(errors.getErrors().isEmpty());
    }

    /**
     * Test of add method, of class Errors.
     */
    @Test
    public void testAdd_ValidationError() {
        System.out.println("add");
        // setup
        ValidationError error = new ValidationError();
        Errors errors = new Errors();

        // test initial state
        assertTrue(errors.getErrors().isEmpty());

        // add the error
        errors.add(error);

        // test
        assertFalse(errors.getErrors().isEmpty());
    }
}
