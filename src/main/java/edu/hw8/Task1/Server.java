package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final static int BufferSize = 1024;
    private final int port;
    private ServerSocketChannel serverSocket;
    private Selector selector;
    private ExecutorService threads;
    private ByteBuffer buffer;

    public Server(int port, int CountOfThreads) throws IOException {
        this.port = port;
        threads = Executors.newFixedThreadPool(CountOfThreads);
        serverSocket = ServerSocketChannel.open();
        selector = Selector.open();
        serverSocket.bind(new InetSocketAddress("localhost", port));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        buffer = ByteBuffer.allocate(BufferSize);
    }

    public void start() throws IOException {
        while (selector.isOpen()) {
            selector.select();
            if (selector.isOpen()) {
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                }
            }
        }
    }
}
