package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("msg=Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            server.close();
                            break;
                        }
                        if (str.contains("msg=Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello\r\n\r\n".getBytes());
                            str = in.readLine();
                            break;
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What\r\n\r\n".getBytes());
                            str = in.readLine();
                            break;
                        }
                    }
                }
            }
        }
    }
}