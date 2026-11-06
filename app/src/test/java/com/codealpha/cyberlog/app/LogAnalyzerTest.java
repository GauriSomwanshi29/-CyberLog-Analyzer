package com.codealpha.cyberlog.app;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    @Test
    void testFailedLogins() {

        List<String> logs = Arrays.asList(
            "192.168.1.10 LOGIN_FAILED user=admin",
            "192.168.1.20 LOGIN_FAILED user=root",
            "192.168.1.30 LOGIN_SUCCESS user=gauri"
        );

        assertEquals(2, LogAnalyzer.countFailedLogins(logs));
    }

    @Test
    void testSuccessfulLogins() {

        List<String> logs = Arrays.asList(
            "192.168.1.10 LOGIN_SUCCESS user=gauri",
            "192.168.1.20 LOGIN_FAILED user=admin",
            "192.168.1.30 LOGIN_SUCCESS user=tanvi"
        );

        assertEquals(2, LogAnalyzer.countSuccessfulLogins(logs));
    }

    @Test
    void testFailedAttemptsByIP() {

        List<String> logs = Arrays.asList(
            "192.168.1.20 LOGIN_FAILED user=admin",
            "192.168.1.20 LOGIN_FAILED user=root",
            "192.168.1.30 LOGIN_FAILED user=guest"
        );

        Map<String, Integer> result =
            LogAnalyzer.getFailedAttempts(logs);

        assertEquals(2, result.get("192.168.1.20"));
        assertEquals(1, result.get("192.168.1.30"));
    }
}