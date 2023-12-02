package edu.hw8.Task1;

import java.io.IOException;
import java.util.Scanner;

public class Init {

    private Init(){
    }

    public static void main(String[] args) throws Exception{

        Thread thread1 = new Thread(
            ()-> {
                try {
                    Server server = new Server(8080, 5);
                    server.start();
                }
                catch(Exception e){
                    throw new RuntimeException(e);
                }
            });

        Thread thread2 = new Thread(
            ()-> {
                try {
                    Client client = new Client("localhost", 8080);
                    client.sendToServer("vovan tut");
                }
                catch(Exception e){
                    throw new RuntimeException(e);
                }
            });
            thread1.start();
            thread2.start();
            try{
                thread1.join();
                thread2.join();
            } catch(Exception e){
            }
    }
}
