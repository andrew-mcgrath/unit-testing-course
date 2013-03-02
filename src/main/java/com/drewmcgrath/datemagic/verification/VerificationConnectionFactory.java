/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.verification;

/**
 *
 * @author amcgrath
 */
public class VerificationConnectionFactory {

    /**
     * Creates a connection to be used for verification
     *
     * @return
     */
    public static VerificationConnection createConnection() {
        VerificationConnection connection = new VerificationConnection() {
            @Override
            public boolean isDangerous(String ssn) {
                throw new UnsupportedOperationException("Connection unavailable");
            }
        };
        return connection;
    }
}
