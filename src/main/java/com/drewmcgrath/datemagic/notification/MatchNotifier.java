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
public interface MatchNotifier {

    /**
     * Notify the profile with the given match
     *
     * @param profileToNotify
     * @param matches
     */
    public void notify(Profile profileToNotify, Collection<Profile> matches);
}
