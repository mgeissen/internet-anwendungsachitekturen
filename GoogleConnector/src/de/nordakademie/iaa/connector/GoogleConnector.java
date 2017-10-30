package de.nordakademie.iaa.connector;

import java.io.*;
import java.net.Socket;

public class GoogleConnector {

    public static void main(String[] args) {
        try(Socket googleConnection = new Socket("www.google.de",80)) {
            // write request
            PrintWriter printWriter = new PrintWriter(googleConnection.getOutputStream());
            printWriter.println("GET / HTTP/1.0");
            printWriter.println();
            printWriter.flush();

            // read response
            InputStreamReader inputStreamReader = new InputStreamReader(googleConnection.getInputStream());
            new BufferedReader(inputStreamReader).lines().forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
