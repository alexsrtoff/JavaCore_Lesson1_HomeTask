package Lesson6;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleEchoServer {
    public static void main(String[] args) {

        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8191)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            System.out.println(str);

                            if (str.equals("/end")) {
                                break;
                            }
                        }
                    }catch (IOException e){
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
                                String serverMessage = sc.nextLine();
                                out.writeUTF("Server message: " + serverMessage);
                            }
                        }catch (IOException e) {
                                e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
