package lesson22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    public static final int SERVER_PORT = 2048;
    public static final char COMMAND_SYMBOL = '/';
    public static final String EXIT_COMMAND = COMMAND_SYMBOL + "exit";
    public static final String RENAME_COMMAND = COMMAND_SYMBOL + "rename";
    public static final String WHO_COMMAND = COMMAND_SYMBOL + "who";

    private List<ClientHandler> clients;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer(){
        int clientCount = 0;
        clients = new ArrayList<>();
        System.out.println("Server started...");
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                String name = "Client #" + ++clientCount;
                System.out.println(name + ": joined.");
                sendToAll(name, name + " joined.", true);
                ClientHandler client = new ClientHandler(socket, name);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(String name, String message, boolean systemMsg) {
        message = (systemMsg) ?  "System: " + message : name + ": " + message;

        for (ClientHandler client : clients) {
            if (!client.getName().equals(name)) {
                client.send(message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private BufferedReader reader;
        private PrintWriter writer;
        private Socket socket;
        private String name;

        public ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void send(String message) {
            writer.println(message);
            writer.flush();
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            String message;
            String[] command;
            boolean sysMsg = false;
            boolean hideMsg = false;
            try {
                do {
                    message = reader.readLine();
                    if (message == null) {
                        return;
                    }

                    if (message.charAt(0) == COMMAND_SYMBOL) {
                        hideMsg = true;
                        command = message.split("\\s+",2);

                        if (command[0].equalsIgnoreCase(EXIT_COMMAND)) {
                            send(message);
                            message = name + " disconnected.";
                            clients.remove(this);
                            sysMsg = true;
                            hideMsg = false;
                        } else if (command[0].equalsIgnoreCase(WHO_COMMAND)) {
                            message = "Online list:\n";
                            for (ClientHandler client : clients) {
                                if (client.getName().equals(name)) {
                                    message = message + client.getName() + " (you)\n";
                                } else {
                                    message = message + client.getName() + "\n";
                                }
                            }
                            send(message);
                        } else if (command[0].equalsIgnoreCase(RENAME_COMMAND)) {
                            if (command[1] != null) {
                                send(message);
                                message = name + " renamed to " + command[1];
                                name = command[1];
                                sysMsg = true;
                                hideMsg = false;
                            }
                        }
                    }
                    if (!hideMsg) {
                        sendToAll(name, message, sysMsg);
                    }
                    System.out.println(name + ": " + message);
                } while (!message.equalsIgnoreCase(EXIT_COMMAND));
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
            System.out.println(name + ": disconnected.");
        }
    }
}
