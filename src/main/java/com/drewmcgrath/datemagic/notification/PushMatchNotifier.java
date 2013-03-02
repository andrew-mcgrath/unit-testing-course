/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import com.drewmcgrath.mobile.push.PushService;
import java.util.Collection;

/**
 *
 * @author amcgrath
 */
public class PushMatchNotifier implements MatchNotifier {

    private PushService pushService;
    private PushNotificationBuilder pushNotificationBuilder;

    public PushMatchNotifier() {
    }

    @Override
    public void notify(Profile profileToNotify, Collection<Profile> matches) {
        for (Profile match : matches) {
            notify(profileToNotify, match);
        }
    }

    protected void notify(Profile profileToNotify, Profile matchedProfile) {
        pushService.send(profileToNotify.getMobilePhone(), pushNotificationBuilder.build(matchedProfile));
    }

    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }

    public PushNotificationBuilder getPushNotificationBuilder() {
        return pushNotificationBuilder;
    }

    public void setPushNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        this.pushNotificationBuilder = pushNotificationBuilder;
    }
}
