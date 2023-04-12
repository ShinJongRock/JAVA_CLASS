package asdf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class ServerExample4 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9002);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("�겢�씪�씠�뼵�듃 �뿰寃� �젒�닔�맖..");

                Thread thread = new PerClinetThread(socket);
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}