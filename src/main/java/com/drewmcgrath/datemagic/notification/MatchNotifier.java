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

    public void notify(Profile profile, Collection<Profile> matches);
}
