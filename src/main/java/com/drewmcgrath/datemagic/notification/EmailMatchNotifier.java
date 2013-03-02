/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.notification;

import com.drewmcgrath.datemagic.domain.Profile;
import java.util.Collection;
import java.util.MissingResourceException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author amcgrath
 */
public class EmailMatchNotifier implements MatchNotifier {

    // constants
    protected static final String USER_NAME = "mail.smtp.username";
    protected static final String PASSWORD = "mail.smtp.password";
    protected static final String HOST = "mail.smtp.host";
    // members
    private Session mailSession = null;
    // injected
    private Properties configuration = null;

    /**
     * Constructor
     */
    public EmailMatchNotifier() {
    }

    /**
     * Initializes the email notification class with the properties
     * configuration that was set on it before calling this method
     *
     * @throws MissingResourceException if any of the configuration is missing
     */
    public void init() {
        // if the configuration is missing
        if (configuration == null) {
            throw new MissingResourceException("Configuration unset", "EmailMatchNotifier", "configuration");
        }
        // verify username was in the configuration
        final String username = configuration.getProperty(USER_NAME);
        if (username == null) {
            throw new MissingResourceException("Email username missing", "EmailMatchNotifier", USER_NAME);
        }
        // verify password was in the configuration
        final String password = configuration.getProperty(PASSWORD);
        if (password == null) {
            throw new MissingResourceException("Email password missing", "EmailMatchNotifier", PASSWORD);
        }
        // verify host was in the configuration
        String host = configuration.getProperty(HOST);
        if (host == null) {
            throw new MissingResourceException("Email host missing", "EmailMatchNotifier", HOST);
        }
        // create the authenticator
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        // establish the mail session
        mailSession = Session.getInstance(configuration, authenticator);
    }

    //<editor-fold defaultstate="collapsed" desc="hidden">
    @Override
    public void notify(Profile profile, Collection<Profile> matches) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the current mail session
     *
     * @return
     */
    protected Session getSession() {
        return this.mailSession;
    }

    protected void setSession(Session session) {
        this.mailSession = session;
    }

    public Properties getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Properties configuration) {
        this.configuration = configuration;
    }
    //</editor-fold>
}
