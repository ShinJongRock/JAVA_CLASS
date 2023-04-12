package server;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerApplication {

    public static ArrayList<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(55555);
            System.out.println("\033[46m" + "\033[1;37m" + "[SA] 서버 소켓이 정상적으로 생성되었습니다." + "\033[0m");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Client client = new Client(clientSocket);
                clients.add(client);
                client.start();
            }

        } catch (SocketException e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[SA] 소켓 관련 예외가 발생했습니다." + "\033[0m");
        } catch (IOException e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[SA] 입출력 관련 예외가 발생했습니다." + "\033[0m");
        }

    }

}