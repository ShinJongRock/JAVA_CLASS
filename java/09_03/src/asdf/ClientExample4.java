package asdf;
import java.net.*;


//�겢�씪�씠�뼵�듃 �겢�옒�뒪
class ClientExample4 {
public ClientExample4(String nickName, Socket socket) {
   if (nickName == null) {
      System.out.println(
            "Usage: java ClientExample4 <user-name>");
      return;
   }
   try {
      Thread thread1 = new SenderThread(socket, nickName);
      Thread thread2 = new ReceiverThread(socket);
      
      thread1.start();
      thread2.start();
   }
   catch (Exception e) {
      System.out.println(e.getMessage());
   }
}
}