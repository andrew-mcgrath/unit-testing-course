/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.domain.validation;

/**
 *
 * @author amcgrath
 */
public class ValidationError {

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
