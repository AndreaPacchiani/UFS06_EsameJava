package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class TCPServer {
    private static final int PORT = 6000;
    private PiattoManager piattoManager = new PiattoManager();

    public static void main(String[] args) {
        new TCPServer().start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server TCP in ascolto sulla porta " + PORT + "...");
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, piattoManager).start();
            }
        } catch (IOException e) {
            System.err.println("Errore durante l'avvio del server: " + e.getMessage());
        }
    }
}