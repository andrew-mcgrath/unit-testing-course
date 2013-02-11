/**
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.testing.comic.domain;

/**
 *
 * @author amcgrath
 */
public class ComicBookCharacter {

    private CharacterType characterType;
    private String name;
    private SecretIdentity secretIdentity;

    public ComicBookCharacter() {
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecretIdentity getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(SecretIdentity secretIdentity) {
        this.secretIdentity = secretIdentity;
    }
}
