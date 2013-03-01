/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.search;

import com.drewmcgrath.datemagic.domain.Profile;
import java.util.List;

/**
 *
 * @author amcgrath
 */
public interface ProfileMatchingService {

    /**
     * Returns a list of profiles that match the current one
     *
     * @param profile
     * @return
     */
    public List<Profile> matchProfile(Profile profile);
}
