package com.drewmcgrath.datemagic.domain

import spock.lang.Specification

import static com.drewmcgrath.datemagic.domain.PersonalInterest.*

/**
 * User: amcgrath
 * Date: 9/24/13
 * Time: 12:20 PM
 */
class PersonalInterestSpec extends Specification {

    def "validate that enums are correctly created from strings"() {
        expect:
        output == PersonalInterest.fromDisplayText(input)

        where:
        input                       | output
        null                        | null
        "nothing that matches"      | null
        "Dancing"                   | DANCING
        "Dining"                    | DINING
        "Underwater Basket Weaving" | UNDER_WATER_BASKET_WEAVING
        "DaNcInG"                   | DANCING
        "DiNing"                    | DINING
        "UnderWater BasKet WeaVing" | UNDER_WATER_BASKET_WEAVING
    }
}
