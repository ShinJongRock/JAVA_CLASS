import java.io.*;
import java.net.*;

public class UiClient {
	private String ip;
	private int port;
	private String str;
	BufferedReader file;
	BufferedWriter bufferW;
	BufferedReader bufferR;
	Socket tcpSocket;

	public UiClient(String ip, int port) throws IOException {
		this.ip = ip;
		this.port = port;

		try {
			tcpSocket = getSocket();		
			System.out.println("서버 연결");
			System.out.println("클라이언트");
			OutputStream os_socket = tcpSocket.getOutputStream();
			InputStream is_socket = tcpSocket.getInputStream();
			bufferW = new BufferedWriter(new OutputStreamWriter(os_socket));
			bufferR = new BufferedReader(new InputStreamReader(is_socket));

			while (true) {
				System.out.print("입력 : ");
				file = new BufferedReader(new InputStreamReader(System.in));
				str = file.readLine(); 

				if (str.equals("exit")) {
					str = "exit";
					str += System.getProperty("line.separator");

					bufferW.write(str);
					bufferW.flush(); 
					System.out.println("종료되었습니다.");
					break;
				}
				
				str += System.getProperty("line.separator");

				bufferW.write(str);
				bufferW.flush(); 

				
				str = bufferR.readLine();
				System.out.println("Server Result : " + str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Client End");
			if (file != null)
				file.close();
			if (bufferW != null)
				bufferW.close();
			if (bufferR != null)
				bufferR.close();
			if (tcpSocket != null)
				tcpSocket.close();

		}
	}

	public Socket getSocket() {
		Socket tcpSocket = null;
		try {
			tcpSocket = new Socket(ip, port);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}
		return tcpSocket;
	}

	public static void main(String[] args) throws IOException {
		new UiClient("localhost", 3000);
	}

}
