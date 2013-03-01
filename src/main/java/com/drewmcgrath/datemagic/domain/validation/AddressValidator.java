/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import com.drewmcgrath.datemagic.domain.Address;

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
        return errors;
    }
}
