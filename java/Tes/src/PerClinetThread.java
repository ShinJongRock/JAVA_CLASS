import java.io.*;
import java.net.*;
import java.util.*;

class PerClinetThread extends Thread {

   static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
//   static Map<String, Socket> clientInfo = Collections.synchronizedMap(new HashMap<>()); // 소캣이랑 닉네임 저장
  
   
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
      // 만약 닉네임과 소켓이 빈 값이 아니라면..
//      if (nickName != null && socket != null) {
//         System.out.println(nickName);
//         System.out.println(socket);
//         st.clientInfo.put(nickName, socket);
//         System.out.println("크기: " + st.clientInfo.size());
//      }
//      
      
      String name = null;
      try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         name = reader.readLine();
         sendAll("#" + name + "님이 채팅방에 참여하였습니다.");
         
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
         sendAll("#" + name + "님이 채팅방에서 퇴장하셨습니다.");
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