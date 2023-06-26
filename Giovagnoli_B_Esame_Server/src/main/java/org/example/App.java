package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
public class App
{
    public static void main( String[] args )
    {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server started");

        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }
}
