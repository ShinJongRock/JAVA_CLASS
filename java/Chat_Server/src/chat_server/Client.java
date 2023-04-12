package chat_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// 클라이언트로부터 메세지를 전달 받는 메소드
	public void receive() {
		Runnable thread = new Runnable() {
			// 하나의 쓰레드가 어떤 동작을 할건지 정의
			@Override
			public void run() {
				try {
					// 메세지를 받을 때
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						// 어떤 메세지를 읽어 들일때에 있어서 오류가 발생했다면 오류 발생 알림
						int length = in.read(buffer);
						while(length == -1) throw new IOException();
						System.out.println("[메세지 수신 성공]" 
								// 현재 접속을 한 클라이언트에 주소 정보를 출력
								+ socket.getRemoteSocketAddress() 
								// 쓰레드의 고유한 정보를 출력(이름값)
								+ ": " + Thread.currentThread().getName());
						// 버퍼에서 전달받은 내용을 message에 담아서 출력
						String message = new String(buffer, 0, length, "UTF-8");
						// 전달받은 message를 다른 클라이언트들에게도 보냄
						for (Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch(Exception e) {
					try {
						System.out.println("[메세지 수신 오류] "
								// 메세지를 전달하는 과정에서 오류가 발생했다면
								// 메세지를 보낸 클라이언트의 주소 정보를 출력
								+ socket.getRemoteSocketAddress()
								// 해당 쓰레드의 고유 이름을 출력
								+ ": " + Thread.currentThread().getName());
					} catch(Exception e2) {
						e.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);
	}
	
	// 클라이언트에게 메세지를 전송하는 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					// 오류가 발생하지 않았을 때, 서버에서 클라이언트로 전송해줌
					out.write(buffer);
					// 반드시 flush를 통해, 여기까지 전송했다는 것을 알려줌
					out.flush();
				} catch(Exception e) {
					try {
						System.out.println("[메세지 송신 오류]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						// 오류가 발생했다면 해당 클라이언트가 서버로부터 접속 끊기므로
						// 서버 안에서도 해당 서버 클라이언트가 끊겼다고 알려줌(제거)
						Main.clients.remove(Client.this);
						// 오류가 생긴 클라이언트의 소켓을 닫아버림
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			
		};
		Main.threadPool.submit(thread);
	}
}
