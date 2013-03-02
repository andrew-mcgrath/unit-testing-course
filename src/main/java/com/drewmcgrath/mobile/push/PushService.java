/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.mobile.push;

/**
 *
 * @author amcgrath
 */
public interface PushService {

    /**
     * Send a push notification to the given number
     *
     * @param phoneNumber
     * @param message
     */
    public void send(String phoneNumber, String message);
}
