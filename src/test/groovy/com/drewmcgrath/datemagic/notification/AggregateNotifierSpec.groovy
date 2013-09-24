package com.drewmcgrath.datemagic.notification

import com.drewmcgrath.datemagic.domain.Profile
import spock.lang.Specification

import static com.drewmcgrath.datemagic.domain.NotificationType.EMAIL
import static com.drewmcgrath.datemagic.domain.NotificationType.SMS

/**
 * User: amcgrath
 * Date: 9/24/13
 * Time: 1:22 PM
 */
class AggregateNotifierSpec extends Specification {

    def "notify a user via multiple mechanisms"() {
        given: "a profile with multiple notification types"
        Profile profile = new Profile(preferedNotificationList: [SMS, EMAIL]);

        and: "match notifiers"
        EmailMatchNotifier emailMatchNotifier = Mock(EmailMatchNotifier);
        SmsMatchNotifier smsMatchNotifier = Mock(SmsMatchNotifier);
        PushMatchNotifier pushMatchNotifier = Mock(PushMatchNotifier);

        and: "an aggregate notifier"
        AggregateNotifier instance = new AggregateNotifier(emailMatchNotifier: emailMatchNotifier,
                smsMatchNotifier: smsMatchNotifier, pushMatchNotifier: pushMatchNotifier);

        and: "a collection of matched profiles"
        Collection<Profile> matches = []

        when:
        instance.notify(profile, matches);

        then:
        1 * smsMatchNotifier.notify(profile, matches)
        1 * emailMatchNotifier.notify(profile, matches)
        0 * smsMatchNotifier._
    }
}
