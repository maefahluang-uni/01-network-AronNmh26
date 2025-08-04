package th.mfu;

import java.io.*;
import java.net.*;

public class MockWebClient {
    public static void main(String[] args) {

        // Try-with-resources ensures the socket and streams are closed automatically
        try (
            Socket socket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Send an HTTP GET request to the web server
            String request = "GET / HTTP/1.1\r\nHost: localhost\r\nConnection: close\r\n\r\n";
            out.print(request);
            out.flush();

            // Read and print the response from the server
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
