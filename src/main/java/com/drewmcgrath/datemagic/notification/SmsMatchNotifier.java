/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import com.drewmcgrath.sms.SmsService;
import java.util.Collection;
import org.apache.log4j.Logger;

/**
 *
 * @author amcgrath
 */
public class SmsMatchNotifier implements MatchNotifier {

    // logger
    private static final Logger LOG = Logger.getLogger(SmsMatchNotifier.class);
    // injected
    private NotificationBuilder builder = null;
    private SmsService smsService = null;

    /**
     * Constructor
     */
    public SmsMatchNotifier() {
        // empty
    }

    @Override
    public void notify(Profile profileToNotify, Collection<Profile> matches) {
        String phoneNumber = profileToNotify.getMobilePhone();
        for (Profile match : matches) {
            String message = builder.build(match);
            smsService.send(phoneNumber, message);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public NotificationBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(NotificationBuilder builder) {
        this.builder = builder;
    }

    public SmsService getSmsService() {
        return smsService;
    }

    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }
    //</editor-fold>
}
