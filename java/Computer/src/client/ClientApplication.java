package client;

import java.net.*;
import java.io.IOException;

public class ClientApplication {

    public static void main(String[] args) throws InterruptedException {
        try {
            Socket socket = new Socket("localhost", 55555);
            System.out.println("\033[42m" + "\033[1;37m" + "[C] 서버에 연결되었습니다." + "\033[0m");

            ServerWriter serverWriter = new ServerWriter(socket);
            ServerListener serverListener = new ServerListener(socket);

            serverWriter.start();
            serverListener.start();

        } catch (IOException e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[C] 서버 연결에 실패하였습니다." + "\033[0m");
        }
    }

}