
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MainSerber {
	public static void main(String[] args) {
		try {
			ServerSocket s_socket = new ServerSocket(8888);
			Socket c_socket = s_socket.accept();
			
			OutputStream output_data = c_socket.getOutputStream();
			
			String sendDataString = "Welcome to Server";
			output_data.write(sendDataString.getBytes());
			
			s_socket.close();
			c_socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
