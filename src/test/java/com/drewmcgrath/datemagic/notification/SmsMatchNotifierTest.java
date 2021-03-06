/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.drewmcgrath.mobile.sms.SmsService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author amcgrath
 */
public class SmsMatchNotifierTest {

    public SmsMatchNotifierTest() {
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
     * Test of notify method, of class SmsMatchNotifier.
     */
    @Test
    public void testNotify() {
        System.out.println("notify");
        // create the profile to notify
        Profile profileToNotify = createProfile("5558675309");
        // create the match list
        List<Profile> matchList = new ArrayList<Profile>();
        Profile match1 = createProfile("5551112222");
        matchList.add(match1);
        Profile match2 = createProfile("5551113333");
        matchList.add(match2);

        // notifier instance
        SmsMatchNotifier instance = new SmsMatchNotifier();
        // mock the builder
        SmsNotificationBuilder mockSmsNotificationBuilder = mock(SmsNotificationBuilder.class);
        when(mockSmsNotificationBuilder.build(match1)).thenReturn("match1 message");
        when(mockSmsNotificationBuilder.build(match2)).thenReturn("match2 message");
        instance.setBuilder(mockSmsNotificationBuilder);

        // mock the sms service
        SmsService mockSmsService = mock(SmsService.class);
        instance.setSmsService(mockSmsService);

        // invoke
        instance.notify(profileToNotify, matchList);

        // verify sms notification builder
        verify(mockSmsNotificationBuilder, times(2)).build(any(Profile.class));
        verify(mockSmsNotificationBuilder, times(1)).build(match1);
        verify(mockSmsNotificationBuilder, times(1)).build(match2);

        // verify sms service
        verify(mockSmsService, times(2)).send(any(String.class), any(String.class));
        verify(mockSmsService, times(1)).send("5558675309", "match1 message");
        verify(mockSmsService, times(1)).send("5558675309", "match2 message");
    }

    /**
     * Return a profile with a mobile phone number
     *
     * @param mobilePhoneNumber
     * @return
     */
    private Profile createProfile(String mobilePhoneNumber) {
        Profile profile = new Profile();
        profile.setMobilePhone(mobilePhoneNumber);
        return profile;
    }
}
