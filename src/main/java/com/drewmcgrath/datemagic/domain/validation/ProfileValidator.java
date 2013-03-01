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

    /**
     * Validates the contents of a
     * <code>com.drewmcgrath.datemagic.domain.Profile</code>
     *
     * @param profile
     * @return
     */
    public Errors isProfileComplete(Profile profile) {
        Errors errors = new Errors();
        // validate home address
        errors.add(addressValidator.isAddressComplete(profile.getHomeAddress()));
        // validate work address
        errors.add(addressValidator.isAddressComplete(profile.getWorkAddress()));
        return errors;
    }

    public AddressValidator getAddressValidator() {
        return addressValidator;
    }

    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }
}
