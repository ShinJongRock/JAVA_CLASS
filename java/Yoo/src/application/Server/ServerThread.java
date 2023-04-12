package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import YootGame.Controller;

public class ServerThread extends Thread {
	private Socket socket = null;
	private String id = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
		    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

		    while(true) {
		        String request = bufferedReader.readLine();

		        if(request == null) {
		            System.out.println("������ �����ϴ�.");
		            quitName(printWriter);
		            break;
		        }
		        
		        // ���� ������ Ŭ���̾�Ʈ�� ����ϴ� �ڵ�
		        //
		        //
		        //
		        
		    }
		} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	public void quitName(PrintWriter printwriter) {
		String quit = this.id + "���� ������ �����Ͽ����ϴ�.";
	}
}
	
