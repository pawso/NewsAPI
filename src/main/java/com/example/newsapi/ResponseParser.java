package com.example.newsapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseParser {
    public String parseResponse(String response) throws RuntimeException {

        JSONObject jsonObject = createJsonObject(response);
        validateResponse(jsonObject);

        return createOutputContent(jsonObject);
    }

    private JSONObject createJsonObject(String response) {
        try {
            return new JSONObject(response);
        } catch (JSONException ex) {
            System.out.println("Could not create JSON object: " + ex.getMessage());
            throw new RuntimeException("Response parser error");
        }
    }

    private void validateResponse(JSONObject jsonObject) {
        String status;
        try {
            status = jsonObject.getString("status");
        } catch (JSONException ex) {
            System.out.println("Error while validating json response: " + ex.getMessage());
            throw new RuntimeException("Response parser error");
        }

        if (!"ok".equals(status)) {
            throw new RuntimeException("Response is invalid: " + status);
        }
    }

    private String createOutputContent(JSONObject jsonObject) {
        try {
            String out = "";
            JSONArray articles = jsonObject.getJSONArray("articles");
            for (int i = 0; i < articles.length(); i++) {
                out += createOutputLine(articles.getJSONObject(i));
            }

            return out;

        } catch (JSONException ex) {
            System.out.println("Error while creating output string " + ex.getMessage());
            throw new RuntimeException("ResponseParser failed");
        }
    }

    private String createOutputLine(JSONObject item) throws JSONException {
        return "" + item.getString("title") + ":" + item.getString("description")
                + ":" + item.getString("author")  + "\n";
    }
}
