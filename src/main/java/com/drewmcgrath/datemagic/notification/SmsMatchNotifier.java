/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import com.drewmcgrath.sms.SmsService;
import java.util.Collection;

/**
 *
 * @author amcgrath
 */
public class SmsMatchNotifier implements MatchNotifier {

    private NotificationBuilder builder = null;
    private SmsService smsService = null;

    public SmsMatchNotifier() {
    }

    @Override
    public void notify(Profile profileToNotify, Collection<Profile> matches) {
        String phoneNumber = profileToNotify.getMobilePhone();
        for (Profile match : matches) {
            String message = builder.build(match);
            smsService.send(phoneNumber, message);
        }
    }

    public NotificationBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(NotificationBuilder builder) {
        this.builder = builder;
    }
}
