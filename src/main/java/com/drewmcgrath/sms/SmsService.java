/*
 * Copyright Angel.com 2011
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
