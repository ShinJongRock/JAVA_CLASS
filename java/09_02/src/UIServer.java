import java.io.IOException;
import java.net.*;

public class UIServer {
	private UiServerThread ust;

	private ServerSocket serverS;

	public UIServer(int port) {

		try {
			serverS = new ServerSocket(port);

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);

		}

		while (true) {
			try {
				System.out.println("클라이언트의 요청을 기다리는중");
				Socket tcpSocket = serverS.accept();
				System.out.println("클라이언트의 IP 주소 :" + tcpSocket.getInetAddress().getHostAddress());
				System.out.println("서버");

				ust = new UiServerThread(tcpSocket); // 서버의 소켓 포트를 쓰레드에 인자값으로 전달
				Thread thread = new Thread(ust);
				thread.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new UIServer(3000);

	}

}
