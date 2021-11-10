package ru.gb.homework6;

import javax.print.attribute.standard.QueuedJobCount;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class SimpleClient {
    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public SimpleClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client ready");
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        break;
                    }
                    System.out.println("Server: " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }


        });
        t1.start();

        new Thread(() -> {
            try (BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    String msgInput = stdIn.readLine();
                    if (!msgInput.isEmpty()) {
                        if (msgInput.contains("/end")) {
                            out.writeUTF("/end");
                            closeConnection();
                            System.exit(0);
                            break;
                        }
                        out.writeUTF(msgInput);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new SimpleClient();
        }).start();
    }
}

