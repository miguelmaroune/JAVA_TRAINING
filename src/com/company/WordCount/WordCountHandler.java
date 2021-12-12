package com.company.WordCount;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordCountHandler implements HttpHandler {
    private String text;

    public WordCountHandler(String text) {
        this.text = text;
    }

//The handle method is called on every httpRequest .
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();
        String[] keyValue = query.split("=");
        String action = keyValue[0];
        String word = keyValue[1];
        if (!action.equals("word")) {
            httpExchange.sendResponseHeaders(400, 0);
            return;
        }
//The word we want to count
        long count = countWord(word);
//Change the count into bytes in order to be able to send it back
        byte[] response = Long.toString(count).getBytes();
        httpExchange.sendResponseHeaders(200, response.length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response);
        outputStream.close();
    }

    private long countWord(String word) {
        long count = 0;
        //start from 0 index in the file
        int index = 0;
        while (index >= 0) {
            //if the index is found indexOf will be positive , then add the count and add the index to start from
            // another index and continue the search.
            index = text.indexOf(word, index);

            if (index >= 0) {
                count++;
                index++;
            }
        }
        return count;
    }
}
