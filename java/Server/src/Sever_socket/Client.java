package Sever_socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Socket sk = null;
			
			try {
				sk = new Socket();
				System.out.println("�����û");
				sk.connect(new InetSocketAddress("localhost",5001));
				System.out.println("���Ἲ��");
				
				byte[] bytes = null;
				String message = null;
				
				OutputStream os = sk.getOutputStream();
				message = "hello Server";
				
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("�����ͺ����� ����");
				
				InputStream is = sk.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				
				System.out.println("�����͹ޱ� ����"+ message);
				
				os.close();
				is.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			if(!sk.isClosed()) {
				try {
					sk.close();
				} catch (Exception e) {
					
				}
			}
			
			
	}

}
