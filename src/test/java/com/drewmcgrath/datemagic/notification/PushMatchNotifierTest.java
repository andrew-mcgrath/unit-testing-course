/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import com.drewmcgrath.mobile.push.PushService;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author amcgrath
 */
public class PushMatchNotifierTest {

    public PushMatchNotifierTest() {
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
     * Test of notify method, of class PushMatchNotifier.
     */
    @Test
    public void testNotify_Profile_Collection() {
        System.out.println("notify(Profile,Collection<Profile>)");

        // profile to notify
        Profile profileToNotify = createProfile("5558675309");

        // matches
        Collection<Profile> matches = new ArrayList<Profile>();
        Profile match1 = createProfile("1112223333");
        matches.add(match1);
        Profile match2 = createProfile("1112224444");
        matches.add(match2);

        // create the service
        PushMatchNotifier instance = new PushMatchNotifier();

        // create the spy
        PushMatchNotifier spy = spy(instance);
        doNothing().when(spy).notify(any(Profile.class), any(Profile.class));

        // invoke
        spy.notify(profileToNotify, matches);

        // verify
        verify(spy, times(1)).notify(profileToNotify, match1);
        verify(spy, times(1)).notify(profileToNotify, match2);
    }

    /**
     * Test of notify method, of class PushMatchNotifier.
     */
    @Test
    public void testNotify_Profile_Profile() {
        System.out.println("notify(Profile,Profile)");
        // profile to notify
        Profile profileToNotify = createProfile("5558675309");

        // matches
        Profile match1 = createProfile("1112223333");
        // mocks
        PushService mockPushService = mock(PushService.class);
        PushNotificationBuilder mockPushNotificationBuilder = mock(PushNotificationBuilder.class);
        when(mockPushNotificationBuilder.build(match1)).thenReturn("match1 push");

        // create the service
        PushMatchNotifier instance = new PushMatchNotifier();
        instance.setPushNotificationBuilder(mockPushNotificationBuilder);
        instance.setPushService(mockPushService);

        // invoke
        instance.notify(profileToNotify, match1);

        // verify
        verify(mockPushNotificationBuilder, times(1)).build(match1);
        verify(mockPushService, times(1)).send("5558675309", "match1 push");
    }

    private Profile createProfile(String phoneNumber) {
        Profile profile = new Profile();
        profile.setMobilePhone(phoneNumber);
        return profile;
    }
}
