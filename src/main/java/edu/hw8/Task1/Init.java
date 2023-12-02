package edu.hw8.Task1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Init {

    private Init(){
    }


    public static void main(String[] args) throws Exception{
        List<String> list = List.of("личности", "оскорбления", "глупый", "интеллект");

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
        client.sendToServer(list.get(ThreadLocalRandom.current().nextInt(4)));
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

