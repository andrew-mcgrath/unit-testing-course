/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.testing.comic.domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author amcgrath
 */
public class TeamTest {

    public TeamTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addMember method, of class Team.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        ComicBookCharacter character = null;
        Team instance = new Team();
        instance.addMember(character);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMember method, of class Team.
     */
    @Test
    public void testRemoveMember() {
        System.out.println("removeMember");
        ComicBookCharacter character = null;
        Team instance = new Team();
        ComicBookCharacter expResult = null;
        ComicBookCharacter result = instance.removeMember(character);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
