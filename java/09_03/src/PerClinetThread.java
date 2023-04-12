import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PerClinetThread extends Thread {

   static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
//   List<String> clientInfo = new ArrayList<>();// ��Ĺ�̶� �г��� ����
   
   Socket socket;
   PrintWriter writer;
   String nickName;
   ArrayList<String> cInfo;
   PerClinetThread(Socket socket, ArrayList<String> cInfo) {
      this.socket = socket;
      this.cInfo = cInfo;
      
      try {
         writer = new PrintWriter(socket.getOutputStream());
         list.add(writer);
        
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
   }
   
   public void run() {
      String name = null;
      try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         name = reader.readLine();
         sendAll("#" + name + "���� ä�ù濡 �����Ͽ����ϴ�.");
         this.cInfo.add(name);
         System.out.println(this.cInfo.get(0));
         
         while (true) {
            String str = reader.readLine();
            if (str == null)
               break;
            sendAll(name + ">" + str);
            
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         list.remove(writer);
         sendAll("#" + name + "���� ä�ù濡�� �����ϼ̽��ϴ�.");
         
         try {
            socket.close();
         } catch (Exception ignored) {
         }
      }
   }

   
   private void sendAll(String str) {
      for (PrintWriter writer : list) {
         writer.println(str);
         writer.flush();
      }
   }
}