/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.mobile.sms;

/**
 *
 * @author amcgrath
 */
public interface SmsService {

    /**
     * Send an sms notification to a given phone number
     *
     * @param phoneNumber
     * @param message
     */
    public void send(String phoneNumber, String message);
}
