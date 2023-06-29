package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.List;

public class ClientHandler extends Thread {
    private Socket socket;
    private PiattoManager piattoManager;

    public ClientHandler(Socket socket, PiattoManager piattoManager) {
        this.socket = socket;
        this.piattoManager = piattoManager;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                try {
                    Command command = Command.valueOf(inputLine);
                    Answer answer = null;
                    switch (command) {
                        case all:
                            answer = new Answer(piattoManager.getPiatti());
                            break;
                        case all_vegans:
                            answer = new Answer(piattoManager.getPiattiVegani());
                            break;
                        case more_caloric:
                            answer = new Answer(Collections.singletonList(piattoManager.getPiattoConCalorieMaggiori()));
                            break;
                    }
                    Gson gson = new Gson();
                    String jsonAnswer = gson.toJson(answer);
                    out.println(jsonAnswer);
                } catch (IllegalArgumentException e) {
                    out.println("Comando non valido");
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la comunicazione con il client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Errore durante la chiusura del socket: " + e.getMessage());
            }
        }
    }
}