/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.notification;

import java.util.MissingResourceException;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amcgrath
 */
public class EmailMatchNotifierTest {

    public EmailMatchNotifierTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = MissingResourceException.class)
    public void testInitNullConfigurationExpected() throws Exception {
        System.out.println("initNullConfigurationExpected");
        EmailMatchNotifier instance = new EmailMatchNotifier();
        instance.init();
    }

    /**
     * Test of init method, of class EmailMatchNotifier.
     */
    @Test
    public void testInitNullConfiguration() {
        System.out.println("initNullConfiguration");
        try {
            EmailMatchNotifier instance = new EmailMatchNotifier();
            instance.init();
            fail("Missing resource exception should have been thrown");
        }
        catch (MissingResourceException mre) {
            assertEquals("EmailMatchNotifier", mre.getClassName());
            assertEquals("configuration", mre.getKey());
            assertEquals("Configuration unset", mre.getMessage());
        }
    }

    @Test
    public void testInitMissingUsername() throws Exception {
        System.out.println("initMissingUsername");
        try {
            EmailMatchNotifier instance = new EmailMatchNotifier();
            Properties configuration = createConfigurationProperties();
            configuration.remove("mail.smtp.username");
            instance.setConfiguration(configuration);
            instance.init();
            fail("Missing resource exception should have been thrown");
        }
        catch (MissingResourceException mre) {
            assertEquals("EmailMatchNotifier", mre.getClassName());
            assertEquals("mail.smtp.username", mre.getKey());
            assertEquals("Email username missing", mre.getMessage());
        }
    }

    @Test
    public void testInitMissingPassword() throws Exception {
        System.out.println("initMissingPassword");
        try {
            EmailMatchNotifier instance = new EmailMatchNotifier();
            Properties configuration = createConfigurationProperties();
            configuration.remove("mail.smtp.password");
            instance.setConfiguration(configuration);
            instance.init();
            fail("Missing resource exception should have been thrown");
        }
        catch (MissingResourceException mre) {
            assertEquals("EmailMatchNotifier", mre.getClassName());
            assertEquals("mail.smtp.password", mre.getKey());
            assertEquals("Email password missing", mre.getMessage());
        }
    }

    @Test
    public void testInitMissingHost() throws Exception {
        System.out.println("initMissingHost");
        try {
            EmailMatchNotifier instance = new EmailMatchNotifier();
            Properties configuration = createConfigurationProperties();
            instance.setConfiguration(configuration);
            configuration.remove("mail.smtp.host");
            instance.init();
            fail("Missing resource exception should have been thrown");
        }
        catch (MissingResourceException mre) {
            assertEquals("EmailMatchNotifier", mre.getClassName());
            assertEquals("mail.smtp.host", mre.getKey());
            assertEquals("Email host missing", mre.getMessage());
        }
    }

    @Test
    public void testInitSuccess() throws Exception {
        System.out.println("initSuccess");
        EmailMatchNotifier instance = new EmailMatchNotifier();
        Properties configuration = createConfigurationProperties();
        instance.setConfiguration(configuration);
        instance.init();
        assertNotNull(instance.getSession());
    }

    private Properties createConfigurationProperties() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.username", "burn.addr@gmail.com");
        props.setProperty("mail.smtp.password", "test");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        return props;
    }
}
