/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import java.util.Collection;

/**
 *
 * @author amcgrath
 */
public interface NotificationBuilder {

    /**
     * Build the string that will be sent to the user
     *
     * @param profile
     * @return
     */
    public String build(Profile profile);
}
