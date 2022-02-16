package com.example.newsapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class APIClient {

    static final String DELIMITER = "\\A";

    public String getQueryResponse(String query) throws RuntimeException {
        URLConnection connection = createURLConnection(query);
        InputStream response = createInputStream(connection);

        return new Scanner(response).useDelimiter(DELIMITER).next();
    }

    private URLConnection createURLConnection(String query) {
        try {
            return new URL(query).openConnection();
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL: " + ex.getMessage());
            throw new RuntimeException("getQueryResponse ");
        } catch (IOException ex) {
            System.out.println("Failed to : " + ex.getMessage());
            throw new RuntimeException("getQueryResponse ");
        }
    }

    private InputStream createInputStream(URLConnection connection) {
        try {
            return  connection.getInputStream();
        } catch (IOException ex) {
            System.out.println("Failed to : " + ex.getMessage());
            throw new RuntimeException("getQueryResponse ");
        }
    }
}
