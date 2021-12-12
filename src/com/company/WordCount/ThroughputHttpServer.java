package com.company.WordCount;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {

    private static final String INPUT_FILE = "./resource/war_and_peace.txt";
    private static final int NUMBER_OF_THREADS = 8;


    public static void init() throws IOException {
      String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        //the context will call a handler by sending a request and receiving a response
        server.createContext("/search", new WordCountHandler(text));
       //Create a thread pool and choose a fixed amount of threads which will be reusable
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
       //Map the executor to our server
        server.setExecutor(executor);
        server.start();
    }
}
