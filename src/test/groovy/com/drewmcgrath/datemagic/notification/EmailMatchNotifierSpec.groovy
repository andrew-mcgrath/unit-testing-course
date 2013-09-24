package com.drewmcgrath.datemagic.notification

import spock.lang.Specification

/**
 * User: amcgrath
 * Date: 9/24/13
 * Time: 12:40 PM
 */
class EmailMatchNotifierSpec extends Specification {

    def "when no configuration has been set"() {
        given:
        EmailMatchNotifier instance = new EmailMatchNotifier();

        when:
        instance.init();

        then:
        MissingResourceException e = thrown()
        "Configuration unset" == e.message
        "EmailMatchNotifier" == e.className
        "configuration" == e.key
    }

    def "when no user name is specified"() {
        given: "a configuration missing a user name"
        Properties configuration = createConfigurationProperties()
        configuration.remove("mail.smtp.username");

        and: "an email match notifier with this configuration"
        EmailMatchNotifier instance = new EmailMatchNotifier(configuration: configuration);

        when:
        instance.init()

        then:
        MissingResourceException e = thrown()
        "Email username missing" == e.message
        "EmailMatchNotifier" == e.className
        "mail.smtp.username" == e.key
    }

    def "when no password is specified"() {
        given: "a configuration missing a password"
        Properties configuration = createConfigurationProperties()
        configuration.remove("mail.smtp.password");

        and: "an email match notifier with this configuration"
        EmailMatchNotifier instance = new EmailMatchNotifier(configuration: configuration);

        when:
        instance.init()

        then:
        MissingResourceException e = thrown()
        "Email password missing" == e.message
        "EmailMatchNotifier" == e.className
        "mail.smtp.password" == e.key
    }

    def "when no host is specified"() {
        given: "a configuration missing a host"
        Properties configuration = createConfigurationProperties()
        configuration.remove("mail.smtp.host");

        and: "an email match notifier with this configuration"
        EmailMatchNotifier instance = new EmailMatchNotifier(configuration: configuration);

        when:
        instance.init()

        then:
        MissingResourceException e = thrown()
        "Email host missing" == e.message
        "EmailMatchNotifier" == e.className
        "mail.smtp.host" == e.key
    }

    def "when everything works as planned"() {
        given:
        EmailMatchNotifier instance = new EmailMatchNotifier(configuration: createConfigurationProperties());

        when:
        instance.init()

        then:
        null != instance.session
    }

    private Properties createConfigurationProperties() {
        Properties baseProperties = new Properties()
        baseProperties.setProperty("mail.smtp.username", "burn.addr@gmail.com")
        baseProperties.setProperty("mail.smtp.password", "test")
        baseProperties.setProperty("mail.smtp.auth", "true")
        baseProperties.setProperty("mail.smtp.starttls.enable", "true")
        baseProperties.setProperty("mail.smtp.host", "smtp.gmail.com")
        baseProperties.setProperty("mail.smtp.port", "587")
        return baseProperties
    }
}
