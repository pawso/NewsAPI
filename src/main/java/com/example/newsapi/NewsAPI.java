package com.example.newsapi;

import java.util.Properties;

public class NewsAPI {

    static private String RESULT_FILENAME = "result.txt";

    public static void main(String[] args) {

        Properties appProperties = ConfigReader.readConfig();

        URLCreator URLCreator = new URLCreator(appProperties);
        APIClient apiClient = new APIClient();
        ResponseParser responseParser = new ResponseParser();
        FileWriteHandler fileWriteHandler = new FileWriteHandler();

        String query = URLCreator.getQuery();
        String response = apiClient.getQueryResponse(query);
        String out = responseParser.parseResponse(response);
        fileWriteHandler.writeToFile(out, RESULT_FILENAME);
    }
}

