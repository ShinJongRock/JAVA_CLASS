package server;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Client extends Thread {

    private final Socket socket;
    private String cid;

    Client(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getCid() {
        return cid;
    }

    public void run() {
        try {

            OutputStream out = socket.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);

            long startTime = System.currentTimeMillis();

            while (!socket.isClosed()) {
                String message = din.readUTF();
                String command = getRequestCommand(message);

                switch (command) {
                    case "Hello":
                        this.cid = getCid(message);
                        dout.writeUTF(getResponseMessage(100, "닉네임이 [" + cid + "] (으)로 설정되었습니다."));
                        break;
                    case "Clock":
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH시 mm분 ss초");
                        Date time = new Date();
                        String curTime = timeFormat.format(time);
                        dout.writeUTF(getResponseMessage(110, curTime));
                        break;
                    case "ConnectionTime":
                        long currentTime = System.currentTimeMillis();
                        String maintained = (currentTime - startTime) / 1000 + "(초)";
                        dout.writeUTF(getResponseMessage(180, maintained));
                        break;
                    case "ClientList":
                        List<Client> clients = ServerApplication.clients;
                        StringBuilder clientInfo = new StringBuilder();
                        for (int i = 0; i < clients.size(); i++) {
                            clientInfo.append("\n").append("[").append(i).append("] ");
                            clientInfo.append(clients.get(i).getCid());
                            clientInfo.append(clients.get(i).getSocket().getInetAddress());
                        }
                        dout.writeUTF(getResponseMessage(300, clientInfo.toString()));
                        break;
                    case "Quit":
                        dout.writeUTF(getResponseMessage(350, "서버 연결을 종료합니다."));
                        break;
                    default:
                        dout.writeUTF(getResponseMessage(500, "잘못된 요청입니다. 다시 시도해주세요."));
                        break;
                }
            }

        } catch (EOFException e) {
            ServerApplication.clients.remove(this);
            System.out.println("[S] [" + cid + socket.getInetAddress() + "] 클라이언트의 연결이 해제되었습니다.");
        } catch (Exception e) {
            System.out.println("\033[41m" + "\033[1;37m" + "[S] 예외가 발생했습니다.");
        }
    }

    private String getRequestCommand(String message) {
        return message.split("///")[1];
    }

    private String getCid(String message) {
        return message.split("///")[2].substring(3);
    }

    private String getResponseMessage(int statusCode, String value) {
        return "REQ///" + statusCode + "///" + value + "///END_MSG";
    }

}
