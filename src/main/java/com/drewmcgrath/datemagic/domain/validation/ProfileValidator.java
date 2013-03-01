/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Profile;
import org.apache.commons.lang.StringUtils;

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
        if (profile == null) {
            errors.add(new ValidationError("profile.null"));
        }
        else {
            // first name
            if (StringUtils.isEmpty(profile.getFirstName())) {
                errors.add(new ValidationError("profile.firstname"));
            }
            // last name
            if (StringUtils.isEmpty(profile.getLastName())) {
                errors.add(new ValidationError("profile.lastname"));
            }
            if (StringUtils.isEmpty(profile.getMobilePhone())) {
                errors.add(new ValidationError("profile.mobile"));
            }
            if (StringUtils.isEmpty(profile.getEmailAddress())) {
                errors.add(new ValidationError("profile.email"));
            }
            // validate home address
            errors.add(addressValidator.isAddressComplete(profile.getHomeAddress()));
            // validate work address
            errors.add(addressValidator.isAddressComplete(profile.getWorkAddress()));
        }
        return errors;
    }

    public AddressValidator getAddressValidator() {
        return addressValidator;
    }

    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }
}
