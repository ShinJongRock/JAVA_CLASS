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
    	
    	// ���� ���� ����α�
        try{
        	serverSocket = new ServerSocket();
        	String hostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind( new InetSocketAddress(hostAddress, 8080) );
            System.out.println("������� ������ ��ٸ�����");
            
            // Ŭ���̾�Ʈ ���� ����
            while(true) {
                Socket socket = serverSocket.accept(); 
                System.out.println("IP:"+ socket.getInetAddress());
                // �� Ŭ���̾�Ʈ �� �ϳ��� ������ ����
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
