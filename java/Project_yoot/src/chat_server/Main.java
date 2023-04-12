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
// 자바 fxml 및 css까지 전반적으로 관리할 수 있도록 도와주는 소프트웨어

public class Main extends Application {
	
	// 다양한 클라이언트가 접속했을때 여러 개의 쓰레드들을 효과적으로 관리
	public static ExecutorService threadPool;
	// 접속한 클라이언트들을 관리
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드
	public void startServer(String IP, int port) {
		try {
			// 소켓에 대한 객체 활성화
			serverSocket = new ServerSocket();
			// bind를 통해 서버 컴퓨터 역할을 수행하는 컴퓨터가
			// 자신의 ip 주소, port번호로 특정한 client의 접속을 기다리게 함
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch(Exception e) {
			e.printStackTrace();
			// 서버 소켓이 닫혀있는 상태가 아니라면
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		// 클라이언트가 접속할 때까지 계속 기다리는 쓰레드
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						// 새로운 클라이언트가 접속할 수 있게 만들어줌
						Socket socket = serverSocket.accept();
						// 클라이언트가 접속을 했다면 새로운 클라이언트를 추가해주고 담음
						clients.add(new Client(socket));
						// 로그 출력
						System.out.println("[클라이언트 접속] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e) {
						// 서버가 문제가 생기면 서버를 작동 중지시킴
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				}
			}
		};
		// 쓰레드풀 초기화
		threadPool = Executors.newCachedThreadPool();
		// 쓰레드풀에 현재 클라이언트를 기다리는 쓰레드를 담을 수 있도록 처리
		threadPool.submit(thread);
	}
	
	// 서버의 작동을 중지시키는 메소드
	public void stopServer() {
		try {
			// 현재 작동중인 모든 소켓 닫기
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				// 해당 연결이 끊긴 클라이언트를 제거
				iterator.remove();
			}
			// 서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// 쓰레드 풀 종료
			// shutdown을 통해 자원 할당 해제
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// UI를 생성하고, 실질적으로 프로그램을 동작시키는 메소드
	@Override
	public void start(Stage primaryStage) {
		// 전체 디자인 틀을 담을 수 있는 Pane
		BorderPane root = new BorderPane();
		// 패딩 = 5
		root.setPadding(new Insets(5));
		// 긴 문장의 텍스트가 담길 수 있도록 하는 공간
		TextArea textArea = new TextArea();
		// 어떠한 문장을 단순히 출력만 하고 수정은 불가능하게 만듬
		textArea.setEditable(false);
		textArea.setFont(new Font("나눔고딕", 15));
		root.setCenter(textArea);
		
		// 서버의 작동을 시작하도록 만드는 버튼
		Button toggleButton = new Button("시작하기");
		// 토글 버튼 = 스위치와 같은 역할
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		// 버튼을 담을 수 있도록 함
		root.setBottom(toggleButton);
		
		// 로컬 주소
		String IP = "192.168.2.85";
		int port = 9876;
		
		// 사용자가 토글버튼을 눌렀을 때 이벤트가 발생
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("시작하기")) {
				startServer(IP, port);
				// runLater() 함수를 통해 GUI요소를 출력할 수 있도록 만들어야 한다.
				Platform.runLater(() -> {
					String message = String.format("[서버 시작]\n", IP, port);
					// 메세지를 출력하도록 만듬
					textArea.appendText(message);
					// 토글버튼 내용을 시작하기 -> 종료하기로 바꿈
					toggleButton.setText("종료하기");
				});
			} else {
				// 종료 버튼을 눌렀을 때 서버 종료
				stopServer();
				String message = String.format("[서버 종료]\n", IP, port);
				// 메세지를 출력하도록 만듬
				textArea.appendText(message);
				// 토글버튼 내용을 종료하기 -> 시작하기로 바꿈
				toggleButton.setText("시작하기");
			}
		});
		
		// 화면 크기 구성
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[채팅 서버]");
		// 프로그램 자체를 종료했다면 stopServer() 함수 실행 후 종료
		primaryStage.setOnCloseRequest(event -> stopServer());
		// scene 정보를 화면에 출력
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	// 프로그램의 진입점
	public static void main(String[] args) {
		launch(args);
	}
}
