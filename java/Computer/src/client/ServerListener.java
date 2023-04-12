package client;

import java.io.*;
import java.net.Socket;

public class ServerListener extends Thread {

    private final Socket socket;

    ServerListener(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                String responseMessage = dataInputStream.readUTF();
                String statusCode = getResponseStatusCode(responseMessage);
                printResponseValue(statusCode, getResponseValue(responseMessage));

                if (statusCode.equals("350")) {
                    socket.close();
                    break;
                }
            }
        } catch (EOFException e) {
            System.out.println("\n" + "\033[41m" + "\033[1;37m" + "[C] 서버와의 연결이 해제되었습니다.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[C] 메세지 수신중 문제가 발생하였습니다." + "\033[0m");
        }
    }

    private String getResponseStatusCode(String responseMessage) {
        return responseMessage.split("///")[1];
    }

    private String getResponseValue(String responseMessage) {
        return responseMessage.split("///")[2];
    }

    private void printResponseValue(String statusCode, String responseValue) {
        System.out.println("[S] (" + statusCode + ") " + responseValue + "\n");
    }

}
