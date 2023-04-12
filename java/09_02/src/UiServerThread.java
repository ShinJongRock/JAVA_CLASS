
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
	public void run() {// 클라이언트와 서버간 통신 가능한 인아웃풋
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
				// 클라에서 보내온 메세지 출력
				String messageC = bufferR.readLine();
				System.out.println("근영 : " + messageC);

				// 서버에서 보낸 메시지 다시 클라로 보내기
				System.out.print("종락 : ");
				file = new BufferedReader(new InputStreamReader(System.in));
				messageC = file.readLine();

				if (messageC.equals("exit")) { 
					messageC = "exit";
					messageC += System.getProperty("line.separator");
					bufferW.write(messageC); // 줄바꿈
					bufferW.flush(); 
					System.out.println("종료되었습니다.");
					break; 
				}

				messageC += System.getProperty("line.separator");

				bufferW.write(messageC);
				bufferW.flush(); 
			}
		} catch (SocketException se) {
			System.out.println("종료");
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
