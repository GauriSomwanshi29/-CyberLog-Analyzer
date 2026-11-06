package com.codealpha.cyberlog.app;

public class App {

    public static void main(String[] args) {

        try {

            LogServer.start();

        } catch (Exception e) {

            System.out.println("Server could not start!");
            e.printStackTrace();

        }
    }
}