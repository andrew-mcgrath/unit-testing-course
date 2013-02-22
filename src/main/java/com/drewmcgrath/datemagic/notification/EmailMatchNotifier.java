/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import java.util.Collection;

/**
 *
 * @author amcgrath
 */
public class EmailMatchNotifier implements MatchNotifier {

    @Override
    public void notify(Profile profile, Collection<Profile> matches) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
