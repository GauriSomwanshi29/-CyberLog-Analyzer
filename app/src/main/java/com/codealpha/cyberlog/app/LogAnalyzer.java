package com.codealpha.cyberlog.app;

import java.util.*;

public class LogAnalyzer {

    // Count failed login attempts
    public static int countFailedLogins(List<String> logs) {

        int count = 0;

        for (String log : logs) {

            if (log.contains("LOGIN_FAILED")) {
                count++;
            }
        }

        return count;
    }

    // Count successful login attempts
    public static int countSuccessfulLogins(List<String> logs) {

        int count = 0;

        for (String log : logs) {

            if (log.contains("LOGIN_SUCCESS")) {
                count++;
            }
        }

        return count;
    }

    // Find failed login attempts for each IP
    public static Map<String, Integer> getFailedAttempts(List<String> logs) {

        Map<String, Integer> ipCounts = new HashMap<>();

        for (String log : logs) {

            if (log.contains("LOGIN_FAILED")) {

                String ip = log.split(" ")[0];

                int count = ipCounts.getOrDefault(ip, 0);

                ipCounts.put(ip, count + 1);
            }
        }

        return ipCounts;
    }
}