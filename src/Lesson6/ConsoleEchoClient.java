package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleEchoClient {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8191;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ConsoleEchoClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Scanner sc = new Scanner(System.in);
                        String clientMessage = sc.nextLine();
                        if(clientMessage.equals("/end")) break;
                        out.writeUTF("Message from client: " + clientMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args) {
                new ConsoleEchoClient();
    }
}
