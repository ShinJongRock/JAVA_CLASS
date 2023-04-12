import java.net.*;

public class UiClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",9000);
			Thread t1 = new SenderThread(socket);
			Thread t2 = new ReceiverThread(socket);
			t1.start();
			t2.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
