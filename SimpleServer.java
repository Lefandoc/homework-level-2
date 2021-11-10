package ru.gb.homework6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    static Socket socket = null;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread t2 = new Thread(() -> {
                try (BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                    while (true) {
                        String msgInput = stdIn.readLine();
                        if (!msgInput.isEmpty()) {
                            out.writeUTF(msgInput);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            t2.start();

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.contains("/end")) {
                            System.out.println("Client sent end");
                            break;
                        }
                        System.out.println("Client: " + str);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
