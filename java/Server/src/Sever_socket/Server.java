package Sever_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;


public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("localhost",5001));
			
			while(true) {
				System.out.println("���� ��ٸ�");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("���� ������" + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is  = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0 , readByteCount, "UTF-8");
				System.out.println("������ �ޱ� ����"+ message);
				
				OutputStream os = socket.getOutputStream();
				message = "hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("������ ������ ����");
				
				is.close();
				os.close();
				socket.close();
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!ss.isClosed()) {
			try {
				ss.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
