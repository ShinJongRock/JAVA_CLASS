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
				System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ�����");
				Socket tcpSocket = serverS.accept();
				
				System.out.println("Ŭ���̾�Ʈ��  IP �ּ� : " + tcpSocket.getInetAddress().getHostAddress());
				is = tcpSocket.getInputStream();
				os = tcpSocket.getOutputStream();
				bufferR = new BufferedReader(new InputStreamReader(is));
				bufferW = new BufferedWriter(new OutputStreamWriter(os));
				String message = bufferR.readLine();
				System.out.println("���Ÿ޽��� : "+ message);
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
