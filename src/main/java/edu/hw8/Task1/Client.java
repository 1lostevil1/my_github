package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Client implements AutoCloseable {

    private SocketChannel socket;
    private static ByteBuffer buffer;

    public Client(String host, int port) throws IOException {
        socket = SocketChannel.open(new InetSocketAddress(host, port));
        buffer = ByteBuffer.allocate(1024);
    }

    public void sendToServer(String message) {
        try {
            String str = new String(message.getBytes());
            buffer = ByteBuffer.wrap(str.getBytes());
            socket.write(buffer);
            buffer.clear();
            System.out.println(   "Ваня: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromServer() {
        try {
            buffer = ByteBuffer.allocate(1024);
            buffer.clear();
             socket.read(buffer);
             String tmp = new String(buffer.array(), StandardCharsets.UTF_8);
            System.out.println("Сервер: " +new String(buffer.array()).trim());
            buffer.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }

}
