/**
 * Copyright Andrew McGrath 2013
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

/**
 *
 * @author amcgrath
 */
public class ValidationError {

    // the identifing field that is invalid
    private String field;

    public ValidationError() {
    }

    public ValidationError(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
