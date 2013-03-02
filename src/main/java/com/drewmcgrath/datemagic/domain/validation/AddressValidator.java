/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Address;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author amcgrath
 */
public class AddressValidator {

    /**
     * Returns if the address is complete
     *
     * @param address
     * @return
     */
    public Errors isAddressComplete(Address address) {
        Errors errors = new Errors();
        if (address == null) {
            errors.add(new ValidationError("address.null"));
        }
        else {
            if (StringUtils.isEmpty(address.getStreet())) {
                errors.add(new ValidationError("address.street"));
            }
            if (StringUtils.isEmpty(address.getState())) {
                errors.add(new ValidationError("address.state"));
            }
            if (StringUtils.isEmpty(address.getCity())) {
                errors.add(new ValidationError("address.city"));
            }
            if (StringUtils.isEmpty(address.getZipcode())) {
                errors.add(new ValidationError("address.zipcode"));
            }
        }
        return errors;
    }
}
