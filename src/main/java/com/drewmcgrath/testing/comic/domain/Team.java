/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.testing.comic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amcgrath
 */
public class Team {

    private CharacterType characterAssociation;
    private String name;
    private List<ComicBookCharacter> members = new ArrayList<ComicBookCharacter>();

    public Team() {
    }

    public Team(CharacterType characterAssociation) {
        this.characterAssociation = characterAssociation;
    }

    public CharacterType getCharacterAssociation() {
        return characterAssociation;
    }

    public void setCharacterAssociation(CharacterType characterAssociation) {
        this.characterAssociation = characterAssociation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ComicBookCharacter> getMembers() {
        return members;
    }

    public void setMembers(List<ComicBookCharacter> members) {
        this.members = members;
    }

    /**
     * Adds a character to the team, checking to see if the character is allowed
     * to be on the team by it's association
     *
     * @param character
     */
    public void addMember(ComicBookCharacter character) {
        // TODO: implement
        // TODO: check to see if the character has the same type
        // TODO: throw exception if the character doesn't have the same type
    }

    /**
     * Removes a character from the team
     *
     * @param character
     */
    public ComicBookCharacter removeMember(ComicBookCharacter character) {
        // TODO: implement
        return null;
    }
}
