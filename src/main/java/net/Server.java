package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by jacob on 14-9-21.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(11100);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String readIn = bufferedReader.readLine();
                System.out.println(readIn);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println(new Date() + " | Hello, Jacob");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
