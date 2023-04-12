import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer {
	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverS;
	
	
	public EchoServer(int port) {
		try {
			serverS = new ServerSocket(port);
		} catch (IOException ioe) {
			// TODO: handle exception
			ioe.printStackTrace();
			System.exit(0);
		}
		while(true) {
			try {
				System.out.println("클라이언트의 요청을 기다리는중");
				Socket tcpSocket = serverS.accept();
				
				System.out.println("클라이언트의  IP 주소 : " + tcpSocket.getInetAddress().getHostAddress());
				is = tcpSocket.getInputStream();
				os = tcpSocket.getOutputStream();
				bufferR = new BufferedReader(new InputStreamReader(is));
				bufferW = new BufferedWriter(new OutputStreamWriter(os));
				String message = bufferR.readLine();
				System.out.println("수신메시지 : "+ message);
				message+=System.getProperty("line.separato");
				bufferW.write(message);
				bufferW.flush();
				bufferR.close();
				bufferW.close();
				tcpSocket.close();
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new EchoServer(5555);
	}
}
