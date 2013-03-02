/*
 * Copyright Angel.com 2011
 *
 */
package com.drewmcgrath.datemagic.verification;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.easymock.PowerMock.*;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 *
 * @author amcgrath
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(VerificationConnectionFactory.class)
public class VerificationServiceTest {

    public VerificationServiceTest() {
    }

    /**
     * Test of verifySSN method, of class VerficationService.
     */
    @Test
    public void testVerifySSN() {
        System.out.println("verifySSN");

        // create the instance that we're going to test
        VerificationService service = new VerificationService();

        // mock the static class
        mockStatic(VerificationConnectionFactory.class);

        VerificationConnection mockVerificationConnection = createMock(VerificationConnection.class);

        // we are expecting two different calls to the mock connection in this test
        expect(mockVerificationConnection.isDangerous("1113334444")).andReturn(false);
        expect(mockVerificationConnection.isDangerous("1113335555")).andReturn(true);
        replay(mockVerificationConnection);

        // we are expecting two calls to the connection factory in this test
        expect(VerificationConnectionFactory.createConnection()).andReturn(mockVerificationConnection);
        expect(VerificationConnectionFactory.createConnection()).andReturn(mockVerificationConnection);
        replay(VerificationConnectionFactory.class);

        // assert that the correct values have been returned
        assertFalse(service.verifySSN("1113334444"));
        assertTrue(service.verifySSN("1113335555"));
    }
}
