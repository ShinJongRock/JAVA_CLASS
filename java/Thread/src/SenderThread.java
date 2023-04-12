
import java.io.*;
import java.net.Socket;

public class SenderThread extends Thread {
    Socket socket;

    public SenderThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.flush();

            while (true) {
                String str = reader.readLine();
                if (str.equals("bye"))  // bye치면 종료
                    break;
                writer.println(str);
                writer.flush();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception ignored) {

            }
        }
    }
}