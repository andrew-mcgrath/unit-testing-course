/*
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.sms;

/**
 *
 * @author amcgrath
 */
public interface SmsService {

    public void send(String phoneNumber, String message);
}
