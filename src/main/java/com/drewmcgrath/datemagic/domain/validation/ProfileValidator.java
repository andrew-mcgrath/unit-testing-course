/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Profile;

/**
 *
 * @author amcgrath
 */
public class ProfileValidator {

    private AddressValidator addressValidator;

    public ProfileValidator() {
    }

    public boolean isProfileComplete(Profile profile) {
        // validate home address
        if (!addressValidator.isAddressComplete(profile.getHomeAddress())) {
            return false;
        }
        // validate work address
        if (!addressValidator.isAddressComplete(profile.getWorkAddress())) {
            return false;
        }
        return false;
    }

    public AddressValidator getAddressValidator() {
        return addressValidator;
    }

    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }
}
