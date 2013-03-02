/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.verification;

/**
 *
 * @author amcgrath
 */
public interface VerificationConnection {

    /**
     *
     * @param ssn
     * @return
     */
    public boolean isDangerous(String ssn);
}
