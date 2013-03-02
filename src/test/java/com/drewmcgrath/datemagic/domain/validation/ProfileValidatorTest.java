/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Address;
import com.drewmcgrath.datemagic.domain.Profile;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

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

        // profile to validate
        Profile profile = new Profile();
        profile.setFirstName("Captain");
        profile.setLastName("America");
        profile.setMobilePhone("5558675309");
        profile.setEmailAddress("camerica@justiceleague.org");

        // home address
        Address homeAddress = new Address();
        homeAddress.setStreet("123 home street");
        homeAddress.setCity("gotham");
        homeAddress.setState("va");
        homeAddress.setZipcode("20165");
        profile.setHomeAddress(homeAddress);

        // work address
        Address workAddress = new Address();
        workAddress.setStreet("123 work street");
        workAddress.setCity("gotham");
        workAddress.setState("va");
        workAddress.setZipcode("20165");
        profile.setWorkAddress(workAddress);

        // Address Validator Mock
        AddressValidator mockAddressValidator = mock(AddressValidator.class);
        when(mockAddressValidator.isAddressComplete(any(Address.class))).thenReturn(new Errors());

        // Captor
        ArgumentCaptor<Address> captor = ArgumentCaptor.forClass(Address.class);

        // create the profile validator
        ProfileValidator instance = new ProfileValidator();
        instance.setAddressValidator(mockAddressValidator);

        // invoke
        Errors result = instance.isProfileComplete(profile);

        // verify
        verify(mockAddressValidator, times(2)).isAddressComplete(captor.capture());
        List<Address> capturedAddresses = captor.getAllValues();
        assertEquals(2, capturedAddresses.size());
        assertEquals(homeAddress, capturedAddresses.get(0));
        assertEquals(workAddress, capturedAddresses.get(1));
        assertFalse(result.containsErrors());
    }
}
