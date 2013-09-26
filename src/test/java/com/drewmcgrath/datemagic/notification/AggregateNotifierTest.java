/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.NotificationType;
import com.drewmcgrath.datemagic.domain.Profile;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

/**
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
        notificationTypes.add(NotificationType.EMAIL);
        profile.setPreferedNotificationList(notificationTypes);

        Collection<Profile> matches = new ArrayList<Profile>();
        matches.add(new Profile());
        // mock email
        EmailMatchNotifier mockEmail = mock(EmailMatchNotifier.class);

        // mock sms
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
        verify(mockEmail, times(1)).notify(profile, matches);
        verify(mockPush, times(0)).notify(any(Profile.class), anyCollectionOf(Profile.class));
    }
}
