/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.NotificationType;
import com.drewmcgrath.datemagic.domain.Profile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author amcgrath
 */
public class AggregateNotifierTest {

    public AggregateNotifierTest() {
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
     * Test of notify method, of class AggregateNotifier.
     */
    @Test
    public void testNotify() {
        System.out.println("notify");
        Profile profile = new Profile();
        List<NotificationType> notificationTypes = new ArrayList<NotificationType>();
        notificationTypes.add(NotificationType.SMS);
        profile.setPreferedNotificationList(notificationTypes);

        Collection<Profile> matches = new ArrayList<Profile>();
        // mock sms
        EmailMatchNotifier mockEmail = mock(EmailMatchNotifier.class);

        // mock email
        SmsMatchNotifier mockSms = mock(SmsMatchNotifier.class);

        // mock push
        PushMatchNotifier mockPush = mock(PushMatchNotifier.class);

        // service
        AggregateNotifier instance = new AggregateNotifier();
        instance.setEmailMatchNotifier(mockEmail);
        instance.setSmsMatchNotifier(mockSms);
        instance.setPushMatchNotifier(mockPush);

        // invoke
        instance.notify(profile, matches);

        // verify
        verify(mockSms, times(1)).notify(profile, matches);
        verify(mockSms, times(1)).notify(profile, matches);
    }
}
