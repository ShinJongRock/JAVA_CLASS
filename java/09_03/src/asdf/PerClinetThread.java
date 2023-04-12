package asdf;
import java.io.*;
import java.net.*;
import java.util.*;

class PerClinetThread extends Thread {

   static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
//   static Map<String, Socket> clientInfo = Collections.synchronizedMap(new HashMap<>()); // �냼罹ｌ씠�옉 �땳�꽕�엫 ���옣
  
   
   Socket socket;
   PrintWriter writer;
   String nickName;


   PerClinetThread(Socket socket) {
//      this.nickName = nickName;
      this.socket = socket;
      try {
         writer = new PrintWriter(socket.getOutputStream());
         list.add(writer);
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
      //st = new SixTeam(nickName, socket);
      
      //SixTeam.sixteammain(nickName, socket);
   }
   
   public void run() {
      // 留뚯빟 �땳�꽕�엫怨� �냼耳볦씠 鍮� 媛믪씠 �븘�땲�씪硫�..
//      if (nickName != null && socket != null) {
//         System.out.println(nickName);
//         System.out.println(socket);
//         st.clientInfo.put(nickName, socket);
//         System.out.println("�겕湲�: " + st.clientInfo.size());
//      }
//      
      
	   
	   
      String name = null;
      try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         name = reader.readLine();
         sendAll("#" + name + "�떂�씠 梨꾪똿諛⑹뿉 李몄뿬�븯���뒿�땲�떎.");
         
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
         sendAll("#" + name + "�떂�씠 梨꾪똿諛⑹뿉�꽌 �눜�옣�븯�뀲�뒿�땲�떎.");
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