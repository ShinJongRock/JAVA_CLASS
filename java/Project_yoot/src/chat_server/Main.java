package chat_server;
	
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// JavaFX sceneBuilder
// �ڹ� fxml �� css���� ���������� ������ �� �ֵ��� �����ִ� ����Ʈ����

public class Main extends Application {
	
	// �پ��� Ŭ���̾�Ʈ�� ���������� ���� ���� ��������� ȿ�������� ����
	public static ExecutorService threadPool;
	// ������ Ŭ���̾�Ʈ���� ����
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// ������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
	public void startServer(String IP, int port) {
		try {
			// ���Ͽ� ���� ��ü Ȱ��ȭ
			serverSocket = new ServerSocket();
			// bind�� ���� ���� ��ǻ�� ������ �����ϴ� ��ǻ�Ͱ�
			// �ڽ��� ip �ּ�, port��ȣ�� Ư���� client�� ������ ��ٸ��� ��
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch(Exception e) {
			e.printStackTrace();
			// ���� ������ �����ִ� ���°� �ƴ϶��
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		// Ŭ���̾�Ʈ�� ������ ������ ��� ��ٸ��� ������
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						// ���ο� Ŭ���̾�Ʈ�� ������ �� �ְ� �������
						Socket socket = serverSocket.accept();
						// Ŭ���̾�Ʈ�� ������ �ߴٸ� ���ο� Ŭ���̾�Ʈ�� �߰����ְ� ����
						clients.add(new Client(socket));
						// �α� ���
						System.out.println("[Ŭ���̾�Ʈ ����] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e) {
						// ������ ������ ����� ������ �۵� ������Ŵ
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				}
			}
		};
		// ������Ǯ �ʱ�ȭ
		threadPool = Executors.newCachedThreadPool();
		// ������Ǯ�� ���� Ŭ���̾�Ʈ�� ��ٸ��� �����带 ���� �� �ֵ��� ó��
		threadPool.submit(thread);
	}
	
	// ������ �۵��� ������Ű�� �޼ҵ�
	public void stopServer() {
		try {
			// ���� �۵����� ��� ���� �ݱ�
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				// �ش� ������ ���� Ŭ���̾�Ʈ�� ����
				iterator.remove();
			}
			// ���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// ������ Ǯ ����
			// shutdown�� ���� �ڿ� �Ҵ� ����
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// UI�� �����ϰ�, ���������� ���α׷��� ���۽�Ű�� �޼ҵ�
	@Override
	public void start(Stage primaryStage) {
		// ��ü ������ Ʋ�� ���� �� �ִ� Pane
		BorderPane root = new BorderPane();
		// �е� = 5
		root.setPadding(new Insets(5));
		// �� ������ �ؽ�Ʈ�� ��� �� �ֵ��� �ϴ� ����
		TextArea textArea = new TextArea();
		// ��� ������ �ܼ��� ��¸� �ϰ� ������ �Ұ����ϰ� ����
		textArea.setEditable(false);
		textArea.setFont(new Font("�������", 15));
		root.setCenter(textArea);
		
		// ������ �۵��� �����ϵ��� ����� ��ư
		Button toggleButton = new Button("�����ϱ�");
		// ��� ��ư = ����ġ�� ���� ����
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		// ��ư�� ���� �� �ֵ��� ��
		root.setBottom(toggleButton);
		
		// ���� �ּ�
		String IP = "192.168.2.85";
		int port = 9876;
		
		// ����ڰ� ��۹�ư�� ������ �� �̺�Ʈ�� �߻�
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("�����ϱ�")) {
				startServer(IP, port);
				// runLater() �Լ��� ���� GUI��Ҹ� ����� �� �ֵ��� ������ �Ѵ�.
				Platform.runLater(() -> {
					String message = String.format("[���� ����]\n", IP, port);
					// �޼����� ����ϵ��� ����
					textArea.appendText(message);
					// ��۹�ư ������ �����ϱ� -> �����ϱ�� �ٲ�
					toggleButton.setText("�����ϱ�");
				});
			} else {
				// ���� ��ư�� ������ �� ���� ����
				stopServer();
				String message = String.format("[���� ����]\n", IP, port);
				// �޼����� ����ϵ��� ����
				textArea.appendText(message);
				// ��۹�ư ������ �����ϱ� -> �����ϱ�� �ٲ�
				toggleButton.setText("�����ϱ�");
			}
		});
		
		// ȭ�� ũ�� ����
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[ä�� ����]");
		// ���α׷� ��ü�� �����ߴٸ� stopServer() �Լ� ���� �� ����
		primaryStage.setOnCloseRequest(event -> stopServer());
		// scene ������ ȭ�鿡 ���
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	// ���α׷��� ������
	public static void main(String[] args) {
		launch(args);
	}
}
