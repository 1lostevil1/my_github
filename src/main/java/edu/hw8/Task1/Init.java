package edu.hw8.Task1;

import java.io.IOException;
import java.util.Scanner;

public class Init {

    private Init(){
    }

    public static void main(String[] args) throws Exception{

            Server server = new Server(18080, 1);
            Thread thread = new Thread(() -> {
                try {
                    server.start();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();

            Thread.sleep(1000);

            Client client = new Client("localhost", 18080);
            client.sendToServer("глупый");
            client.readFromServer();
            try {
                client.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Thread.sleep(1000);
            try {
                server.close();
                thread.join();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

