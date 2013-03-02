/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amcgrath
 */
public class Errors {

    private List<ValidationError> errors = new ArrayList<ValidationError>();

    public Errors() {
    }

    public boolean containsErrors() {
        return !errors.isEmpty();
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void add(Errors errors) {
        this.errors.addAll(errors.getErrors());
    }

    public void add(ValidationError error) {
        this.errors.add(error);
    }
}
