/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain;

import java.util.List;

/**
 *
 * @author amcgrath
 */
public class Profile {

    private RelationshipType relationshipType;
    private String firstName;
    private String lastName;
    private int age;
    private List<PersonalInterest> personalInterests;
    private String emailAddress;
    private String mobilePhone;
    private Address homeAddress;
    private Address workAddress;
    private List<NotificationType> preferedNotificationList;

    public Profile() {
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<PersonalInterest> getPersonalInterests() {
        return personalInterests;
    }

    public void setPersonalInterests(List<PersonalInterest> personalInterests) {
        this.personalInterests = personalInterests;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public List<NotificationType> getPreferedNotificationList() {
        return preferedNotificationList;
    }

    public void setPreferedNotificationList(List<NotificationType> preferedNotificationList) {
        this.preferedNotificationList = preferedNotificationList;
    }
}
