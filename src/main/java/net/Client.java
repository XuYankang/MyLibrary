package net;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * Created by jacob on 14-9-21.
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        String serverAddress = JOptionPane.showInputDialog(
//                "Enter IP Address of a machine that is\n" +
//                        "running the date service on port 9090:");
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 11100);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bufferedWriter.write("hello, server");
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);


    }
}
