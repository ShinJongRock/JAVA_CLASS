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
	
	// Ŭ���̾�Ʈ�κ��� �޼����� ���� �޴� �޼ҵ�
	public void receive() {
		Runnable thread = new Runnable() {
			// �ϳ��� �����尡 � ������ �Ұ��� ����
			@Override
			public void run() {
				try {
					// �޼����� ���� ��
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						// � �޼����� �о� ���϶��� �־ ������ �߻��ߴٸ� ���� �߻� �˸�
						int length = in.read(buffer);
						while(length == -1) throw new IOException();
						System.out.println("[�޼��� ���� ����]" 
								// ���� ������ �� Ŭ���̾�Ʈ�� �ּ� ������ ���
								+ socket.getRemoteSocketAddress() 
								// �������� ������ ������ ���(�̸���)
								+ ": " + Thread.currentThread().getName());
						// ���ۿ��� ���޹��� ������ message�� ��Ƽ� ���
						String message = new String(buffer, 0, length, "UTF-8");
						// ���޹��� message�� �ٸ� Ŭ���̾�Ʈ�鿡�Ե� ����
						for (Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch(Exception e) {
					try {
						System.out.println("[�޼��� ���� ����] "
								// �޼����� �����ϴ� �������� ������ �߻��ߴٸ�
								// �޼����� ���� Ŭ���̾�Ʈ�� �ּ� ������ ���
								+ socket.getRemoteSocketAddress()
								// �ش� �������� ���� �̸��� ���
								+ ": " + Thread.currentThread().getName());
					} catch(Exception e2) {
						e.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);
	}
	
	// Ŭ���̾�Ʈ���� �޼����� �����ϴ� �޼ҵ�
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					// ������ �߻����� �ʾ��� ��, �������� Ŭ���̾�Ʈ�� ��������
					out.write(buffer);
					// �ݵ�� flush�� ����, ������� �����ߴٴ� ���� �˷���
					out.flush();
				} catch(Exception e) {
					try {
						System.out.println("[�޼��� �۽� ����]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						// ������ �߻��ߴٸ� �ش� Ŭ���̾�Ʈ�� �����κ��� ���� ����Ƿ�
						// ���� �ȿ����� �ش� ���� Ŭ���̾�Ʈ�� ����ٰ� �˷���(����)
						Main.clients.remove(Client.this);
						// ������ ���� Ŭ���̾�Ʈ�� ������ �ݾƹ���
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
