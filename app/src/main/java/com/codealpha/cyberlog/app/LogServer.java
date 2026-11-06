package com.codealpha.cyberlog.app;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LogServer {

    public static void start() throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

        // Serve website
        server.createContext("/", exchange -> {

            InputStream input = LogServer.class
                .getResourceAsStream("/web/index.html");

            if (input == null) {
                sendResponse(exchange, 404, "Website not found");
                return;
            }

            byte[] html = input.readAllBytes();
            input.close();

            exchange.getResponseHeaders().set(
                "Content-Type", "text/html; charset=UTF-8"
            );

            exchange.sendResponseHeaders(200, html.length);
            exchange.getResponseBody().write(html);
            exchange.close();
        });

        // Analyze uploaded log data
        server.createContext("/api/analyze", exchange -> {

            if (!exchange.getRequestMethod().equals("POST")) {
                sendResponse(exchange, 405, "POST method required");
                return;
            }

            String data = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
            );

            List<String> logs = new ArrayList<>();

            for (String line : data.split("\\R")) {
                if (!line.isBlank()) {
                    logs.add(line.trim());
                }
            }

            int total = logs.size();

            int success =
                LogAnalyzer.countSuccessfulLogins(logs);

            int failed =
                LogAnalyzer.countFailedLogins(logs);

            Map<String, Integer> ipCounts =
                LogAnalyzer.getFailedAttempts(logs);

            StringBuilder json = new StringBuilder();

            json.append("{");
            json.append("\"totalLogs\":").append(total).append(",");
            json.append("\"successLogs\":").append(success).append(",");
            json.append("\"failedLogs\":").append(failed).append(",");
            json.append("\"suspiciousIPs\":[");

            boolean first = true;

            for (Map.Entry<String, Integer> entry : ipCounts.entrySet()) {

                if (entry.getValue() >= 3) {

                    if (!first) {
                        json.append(",");
                    }

                    json.append("{");
                    json.append("\"ip\":\"")
                        .append(entry.getKey()).append("\",");
                    json.append("\"attempts\":")
                        .append(entry.getValue());
                    json.append("}");

                    first = false;
                }
            }

            json.append("]}");

            exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8"
            );

            sendResponse(exchange, 200, json.toString());
        });

        server.start();

        System.out.println("================================");
        System.out.println(" CYBERLOG ANALYZER SERVER STARTED");
        System.out.println(" Website: http://localhost:8080");
        System.out.println("================================");
    }

    private static void sendResponse(
        HttpExchange exchange, int status, String response
    ) throws IOException {

        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }
}