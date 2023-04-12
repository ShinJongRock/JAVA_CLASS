
import java.io.*;
import java.net.*;

public class UiServerThread implements Runnable {

	private Socket tcpSocket;
	private BufferedReader bufferR;
	private BufferedWriter bufferW;

	BufferedReader file;

	public UiServerThread(Socket tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	@Override
	public void run() {// Ŭ���̾�Ʈ�� ������ ��� ������ �ξƿ�ǲ
		try {
			bufferR = new BufferedReader(
					new InputStreamReader(tcpSocket.getInputStream()));
			bufferW = new BufferedWriter(
					new OutputStreamWriter(tcpSocket.getOutputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			while (true) {
				// Ŭ�󿡼� ������ �޼��� ���
				String messageC = bufferR.readLine();
				System.out.println("�ٿ� : " + messageC);

				// �������� ���� �޽��� �ٽ� Ŭ��� ������
				System.out.print("���� : ");
				file = new BufferedReader(new InputStreamReader(System.in));
				messageC = file.readLine();

				if (messageC.equals("exit")) { 
					messageC = "exit";
					messageC += System.getProperty("line.separator");
					bufferW.write(messageC); // �ٹٲ�
					bufferW.flush(); 
					System.out.println("����Ǿ����ϴ�.");
					break; 
				}

				messageC += System.getProperty("line.separator");

				bufferW.write(messageC);
				bufferW.flush(); 
			}
		} catch (SocketException se) {
			System.out.println("����");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Thread End");
				if (file != null)
					file.close();
				if (bufferW != null)
					bufferW.close();
				if (bufferR != null)
					bufferR.close();
				if (tcpSocket != null)
					tcpSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
