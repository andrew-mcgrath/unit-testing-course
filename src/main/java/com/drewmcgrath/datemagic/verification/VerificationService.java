/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.verification;

/**
 *
 * @author amcgrath
 */
public class VerificationService {

    public VerificationService() {
    }

    /**
     * Returns if profile's ssn is allowed to be in our service
     *
     * @param ssn
     */
    public boolean verifySSN(String ssn) {
        VerificationConnection connection = VerificationConnectionFactory.createConnection();
        return connection.isDangerous(ssn);
    }
}
