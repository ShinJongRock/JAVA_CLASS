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
				System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ�����");
				Socket tcpSocket = serverS.accept();
				System.out.println("Ŭ���̾�Ʈ�� IP �ּ� :" + tcpSocket.getInetAddress().getHostAddress());
				System.out.println("����");

				ust = new UiServerThread(tcpSocket); // ������ ���� ��Ʈ�� �����忡 ���ڰ����� ����
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
