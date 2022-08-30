package lesson21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer();
    }

    EchoServer() {
        String msg;
        try (ServerSocket server = new ServerSocket(2048)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection to client...");
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());


                do {
                    msg = reader.readLine();
                    writer.println("Echo: " + msg);
                    System.out.println("Client: " + msg);
                } while (!msg.equals("exit"));

                writer.close();
                reader.close();
                System.out.println("Disconnect from client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
