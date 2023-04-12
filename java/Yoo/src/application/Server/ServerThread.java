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
		            System.out.println("연결이 없습니다.");
		            quitName(printWriter);
		            break;
		        }
		        
		        // 이후 서버와 클라이언트가 통신하는 코드
		        //
		        //
		        //
		        
		    }
		} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	public void quitName(PrintWriter printwriter) {
		String quit = this.id + "님이 연결을 종료하였습니다.";
	}
}
	
