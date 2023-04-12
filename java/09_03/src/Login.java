import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
  
   Socket socket;
   JFrame f1 = new JFrame();
   JButton b1 = new JButton();
   JLabel lbl = new JLabel("CHATTING");
   JLabel lbl1 = new JLabel("NickName");
   JLabel lbl2 = new JLabel("IP              ");
   JLabel lbl3 = new JLabel("PORT       ");
   JTextField tf1 = new JTextField("", 15);
   JTextField tf2 = new JTextField("", 15);
   JTextField tf3 = new JTextField("", 15);
   JPanel p1 = new JPanel(); // nick name
   JPanel p2 = new JPanel(); // ip
   JPanel p3 = new JPanel(); // port
   String nickName;
   static String ip;
   String port;

   // ���� ó�� ����
   JFrame f2 = new JFrame();
   JLabel errorLbl = new JLabel("�ٽ� �Է��ϼ���");
   JButton errorButton = new JButton("Ȯ��");




   // �۾���
   public void label() {
      lbl.setBounds(150, 100, 180, 100);
      lbl.setHorizontalAlignment(lbl.CENTER);
      lbl.setFont(lbl.getFont().deriveFont(30.0f));
      f1.add(lbl);
   }

   // �ý�Ʈ �ڽ� , �۾� panel
   public void textBox() {
      // �г��� panel
      lbl1.setBounds(100, 150, 50, 30);
      lbl1.setFont(lbl2.getFont().deriveFont(14.0f));
      lbl1.setHorizontalAlignment(JLabel.RIGHT);
      p1.add(lbl1);
      p1.add(tf1);
      p1.setBounds(100, 200, 250, 30);
      f1.add(p1);

      // ip panel
      lbl2.setBounds(100, 150, 50, 30);
      lbl2.setSize(80, 30);
      lbl2.setFont(lbl2.getFont().deriveFont(14.0f));
      lbl2.setHorizontalAlignment(JLabel.RIGHT);
      p2.add(lbl2);
      p2.add(tf2);
      p2.setBounds(100, 250, 250, 30);
      f1.add(p2);

      lbl3.setFont(lbl3.getFont().deriveFont(14.0f));
      lbl3.setHorizontalAlignment(JLabel.RIGHT);
      p3.add(lbl3);
      p3.add(tf3);
      p3.setBounds(100, 300, 250, 30);
      f1.add(p3);
      // port panel
   }

   // Frame ����
   public void frame() {
      f1.setTitle("CHATTING");
      f1.setSize(500, 600);
      f1.setLayout(null);
      f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   // ���� ��ư �ڽ�
   public void button() {
      b1.setBounds(200, 400, 100, 40);
      // setBounds ( ���� , ���� , ���α��� , ���α��� )
      b1.setText("����");
      f1.add(b1);

   }

   // ��ư Ŭ�� �̺�Ʈ ó��
   public void clickEvent() {
      b1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            // textField �� ���� �����´�.
            nickName = tf1.getText(); // �г���
            ip = tf2.getText(); // ip
            port = tf3.getText(); // port��ȣ

            // �� ���� �־��� ���, ���� ���
            if (nickName.equals("") || ip.equals("") || port.equals("")) {
               f2.setTitle("����");
               f2.setSize(400, 300);
               f2.setLayout(null);
               errorLbl.setBounds(150, 50, 100, 100);
               errorLbl.setHorizontalAlignment(lbl.CENTER);
               errorLbl.setFont(errorLbl.getFont().deriveFont(13.0f));
               f2.add(errorLbl);
               errorButton.setBounds(150, 130, 100, 40);
               f2.add(errorButton);
               f2.setVisible(true);
               f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

               // ���� ��ư Ŭ�� �̺�Ʈ ó��
               errorLbl.addMouseListener(new MouseAdapter() {
                  public void mouseClicked(MouseEvent e) {
                     f2.dispose();
                  }
               });

            } else {
               // ����� �ۼ����� ���
               socket = null;
               int inputPort = Integer.parseInt(port);
               try {
                  socket = new Socket(ip, inputPort);

                  new ClientExample4(nickName, socket);
                 // new PerClinetThread(nickName, socket);   //nickName�� perClekdkd�� ����
               } catch (Exception e1) {
                  System.out.println(e1.getMessage());
               }
               f1.dispose();
            }
         }

      });
   }

   
   public static void main(String[] args) {
      Login lo = new Login();

      lo.label();
      lo.textBox();
      lo.button();
      lo.clickEvent();
      lo.frame();
      lo.f1.setVisible(true);

      // setBounds ( ���� , ���� , ���α��� , ���α��� )
      // setLocation .: ������Ʈ ��ġ ����
      // setSize : ������Ʈ ũ�� ����
      // setBounds : ������Ʈ ��ġ , ũ�� ����
      // setPriffersize : ������Ʈ ���� ũ�� ����
   }
}