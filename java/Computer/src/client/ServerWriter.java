package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerWriter extends Thread {

    private final Socket socket;

    ServerWriter(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            OutputStream outStream = socket.getOutputStream();
            DataOutputStream dataOutStream = new DataOutputStream(outStream);
            Thread.sleep(100);

            String cid = getCid(scanner);
            System.out.println();
            Thread.sleep(2000);

            int count = 0;
            while (!socket.isClosed()) {
                String command = getRequestCommand(scanner);

                String requestMessage = getRequestMessage(command, cid, ++count);
                dataOutStream.writeUTF(requestMessage);
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[C] 오류가 발생하였습니다." + "\033[0m");
        }
    }

    private static String getCid(Scanner scanner) {
        System.out.print("[C] 닉네임을 입력해주세요: ");
        return scanner.nextLine();
    }

    private static String getRequestCommand(Scanner scanner) {
        System.out.print("[C] 메세지를 입력하세요 : ");
        return scanner.nextLine();
    }

    private static String getRequestMessage(String command, String cid, int count) {
        return "REQ///" + command + "///CID" + cid + "///Num_Req" + count + "///END_MSG";
    }

}
