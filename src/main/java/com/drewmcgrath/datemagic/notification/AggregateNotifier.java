/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.NotificationType;
import com.drewmcgrath.datemagic.domain.Profile;
import java.util.Collection;

/**
 *
 * @author amcgrath
 */
public class AggregateNotifier implements MatchNotifier {

    private SmsMatchNotifier smsMatchNotifier;
    private EmailMatchNotifier emailMatchNotifier;
    private PushMatchNotifier pushMatchNotifier;

    public AggregateNotifier() {
    }

    @Override
    public void notify(Profile profile, Collection<Profile> matches) {
        for (NotificationType notificationType : profile.getPreferedNotificationList()) {
            switch (notificationType) {
                case EMAIL:
                    emailMatchNotifier.notify(profile, matches);
                    break;
                case SMS:
                    smsMatchNotifier.notify(profile, matches);
                    break;
                case PUSH:
                    pushMatchNotifier.notify(profile, matches);
                    break;
            }
        }
    }

    public SmsMatchNotifier getSmsMatchNotifier() {
        return smsMatchNotifier;
    }

    public void setSmsMatchNotifier(SmsMatchNotifier smsMatchNotifier) {
        this.smsMatchNotifier = smsMatchNotifier;
    }

    public EmailMatchNotifier getEmailMatchNotifier() {
        return emailMatchNotifier;
    }

    public void setEmailMatchNotifier(EmailMatchNotifier emailMatchNotifier) {
        this.emailMatchNotifier = emailMatchNotifier;
    }

    public PushMatchNotifier getPushMatchNotifier() {
        return pushMatchNotifier;
    }

    public void setPushMatchNotifier(PushMatchNotifier pushMatchNotifier) {
        this.pushMatchNotifier = pushMatchNotifier;
    }
}
