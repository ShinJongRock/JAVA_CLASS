package asdf;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
   SixTeam team = new SixTeam();
         
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

   // �뿉�윭 泥섎━ 蹂��닔
   JFrame f2 = new JFrame();
   JLabel errorLbl = new JLabel("�떎�떆 �엯�젰�븯�꽭�슂");
   JButton errorButton = new JButton("�솗�씤");

   // 湲��뵪�뱾
   public void label() {
      lbl.setBounds(150, 100, 180, 100);
      lbl.setHorizontalAlignment(lbl.CENTER);
      lbl.setFont(lbl.getFont().deriveFont(30.0f));
      f1.add(lbl);
   }

   // �깮�뒪�듃 諛뺤뒪 , 湲��뵪 panel
   public void textBox() {
      // �땳�꽕�엫 panel
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

   // Frame �꽕�젙
   public void frame() {
      f1.setTitle("CHATTING");
      f1.setSize(500, 600);
      f1.setLayout(null);
      f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   // �젒�냽 踰꾪듉 諛뺤뒪
   public void button() {
      b1.setBounds(200, 400, 100, 40);
      // setBounds ( 媛�濡� , �꽭濡� , 媛�濡쒓만�씠 , �꽭濡쒓만�씠 )
      b1.setText("�젒�냽");
      f1.add(b1);

   }

   // 踰꾪듉 �겢由� �씠踰ㅽ듃 泥섎━
   public void clickEvent() {
      b1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            // textField �쓽 媛믪쓣 媛��졇�삩�떎.
            nickName = tf1.getText(); // �땳�꽕�엫
            ip = tf2.getText(); // ip
            port = tf3.getText(); // port踰덊샇

            // 鍮� 媛믪쓣 �꽔�뿀�쓣 寃쎌슦, �삤瑜� 異쒕젰
            if (nickName.equals("") || ip.equals("") || port.equals("")) {
               f2.setTitle("�삤瑜�");
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

               // �뿉�윭 踰꾪듉 �겢由� �씠踰ㅽ듃 泥섎━
               errorLbl.addMouseListener(new MouseAdapter() {
                  public void mouseClicked(MouseEvent e) {
                     f2.dispose();
                  }
               });

            } else {
               // �젣��濡� �옉�꽦�뻽�쓣 寃쎌슦
               Socket socket = null;
               int inputPort = Integer.parseInt(port);
               try {
                  socket = new Socket(ip, inputPort);

                  new ClientExample4(nickName, socket);
                 // new PerClinetThread(nickName, socket);   //nickName�쓣 perClekdkd�뿉 �쟾�떖
               } catch (Exception e1) {
                  System.out.println(e1.getMessage());
               }
               team.sixteammain(nickName, socket);
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

      // setBounds ( 媛�濡� , �꽭濡� , 媛�濡쒓만�씠 , �꽭濡쒓만�씠 )
      // setLocation .: 而댄룷�꼳�듃 �쐞移� 吏��젙
      // setSize : 而댄룷�꼳�듃 �겕湲� 吏��젙
      // setBounds : 而댄룷�꼳�듃 �쐞移� , �겕湲� 吏��젙
      // setPriffersize : 而댄룷�꼳�듃 理쒖쟻 �겕湲� 吏��젙
   }
}