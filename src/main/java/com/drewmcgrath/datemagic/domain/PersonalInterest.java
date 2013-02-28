/**
 * Copyright drewmcgrath.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain;

/**
 *
 * @author amcgrath
 */
public enum PersonalInterest {

    DINNING("Dinning"),
    DANCING("Dancing"),
    UNDER_WATER_BASKET_WEAVING("Underwater Basket Weaving");
    /**
     * The string that will be displayed on the webpage
     */
    private String displayText;

    /**
     * Constructor
     *
     * @param displayText
     */
    private PersonalInterest(String displayText) {
        this.displayText = displayText;
    }

    /**
     * Returns the display text for the enum
     *
     * @return
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * Returns an enum for the string passed assuming it matches the display
     * text.
     *
     * @param text
     * @return the enum that matches the display text or null if nothing matches
     */
    public static PersonalInterest fromDisplayText(String text) {
        if (text != null) {
            for (PersonalInterest interest : PersonalInterest.values()) {
                if (interest.getDisplayText().equalsIgnoreCase(text)) {
                    return interest;
                }
            }
        }
        return null;
    }
}
