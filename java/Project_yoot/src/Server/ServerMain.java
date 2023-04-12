package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
    
    public static void main(String[] args){
    	
    	ServerSocket serverSocket = null;
    	
    	// 서버 소켓 열어두기
        try{
        	serverSocket = new ServerSocket();
        	String hostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind( new InetSocketAddress(hostAddress, 8080) );
            System.out.println("사용자의 연결을 기다리는중");
            
            // 클라이언트 연결 성공
            while(true) {
                Socket socket = serverSocket.accept(); 
                System.out.println("IP:"+ socket.getInetAddress());
                // 한 클라이언트 당 하나의 쓰레드 지정
                new ServerThread(socket).start();
            }
        } catch(IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if(serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
