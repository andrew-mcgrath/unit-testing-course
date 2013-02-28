/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Profile;
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
public class ProfileValidatorTest {

    public ProfileValidatorTest() {
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
     * Test of isValidProfile method, of class ProfileValidator.
     */
    @Test
    public void testIsValidProfile() {
        System.out.println("isValidProfile");
        Profile profile = null;
        ProfileValidator instance = new ProfileValidator();
        boolean expResult = false;
        boolean result = instance.isValidProfile(profile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
