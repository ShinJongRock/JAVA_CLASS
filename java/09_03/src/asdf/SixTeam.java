package asdf;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.View;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Label;
 
public class SixTeam{
   Login loginInfo;
   private JFrame frame;
   private JTextField textField;
   String getText; // �엯�젰 諛쏆� �궡�슜
   
   public ArrayList<String> nameList = new ArrayList<>();
   String[] chatList;
   String nickName;
   Socket socket;
  
   static JTextArea textArea;
   /**
    * Launch the application.
    */

   // �옄�룞 �겢由� 湲곕뒫
   public void focus1() {
      frame.addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
            textField.requestFocus();
         }
      });
   }

   
   public void sixteammain(String nickName, Socket socket) {
      this.nickName = nickName;
      this.socket = socket;

      initialize();
      frame.setVisible(true);
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               SixTeam window = new SixTeam();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
   }

   /**
    * Create the application.
    */
   public SixTeam() {
      nickName = new String();
      socket = new Socket();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
     
      frame = new JFrame();
      frame.setBounds(100, 100, 700, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      focus1();

      //�엯�젰 �궡�슜 textField
      textField = new JTextField();
      textField.setBounds(22, 604, 513, 49);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      textField.addKeyListener(new KeyListener() {
         public void keyPressed(KeyEvent e) {
             int key = e.getKeyCode();
             if(key ==KeyEvent.VK_ENTER) {
                textArea.append(textField.getText()+"\n");
                textField.setText("");
             
             }
          }

      @Override
      public void keyTyped(KeyEvent e) {}
      @Override
      public void keyReleased(KeyEvent e) {}

            });
     
      // 梨꾪똿 紐⑸줉李�
      textArea = new JTextArea();
      textArea.setBounds(22, 79, 433, 443);
      frame.getContentPane().add(textArea);
      
      // 梨꾪똿 紐⑸줉 �뒪�겕濡�
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(32, 140, 410, 375);
      frame.getContentPane().add(scrollPane);
      scrollPane.setViewportView(textArea);

      JButton btnNewButton = new JButton("�윑�");
      btnNewButton.setFont(btnNewButton.getFont().deriveFont(20.0f));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo1 = textField.getText();
            textField.setText(emo1 + "�윑�");
            textField.requestFocus();
         }
      });

      btnNewButton.setBounds(22, 544, 116, 50);
      frame.getContentPane().add(btnNewButton);

      JButton btnNewButton_1_1 = new JButton("�윑�");
      btnNewButton_1_1.setFont(btnNewButton_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1.setBounds(278, 544, 116, 50);
      btnNewButton_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo2 = textField.getText();
            textField.setText(emo2 + "�윑�");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1_1);

      JButton btnNewButton_1_1_1 = new JButton("�윑�");
      btnNewButton_1_1_1.setFont(btnNewButton_1_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1_1.setBounds(418, 544, 116, 50);
      btnNewButton_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo3 = textField.getText();
            textField.setText(emo3 + "�윑�");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1_1_1);

      JButton btnNewButton_1_1_1_1 = new JButton("�윑�");
      btnNewButton_1_1_1_1.setFont(btnNewButton_1_1_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo4 = textField.getText();
            textField.setText(emo4 + "�윑�");
            textField.requestFocus();
         }
      });
      btnNewButton_1_1_1_1.setBounds(546, 544, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1);

      JButton btnNewButton_1 = new JButton("�윑�");
      btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(20.0f));
      btnNewButton_1.setBounds(150, 544, 116, 50);
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo2 = textField.getText();
            textField.setText(emo2 + "�윑�");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1);
      // �엯�젰 踰꾪듉
      JButton btnNewButton_1_1_1_1_1 = new JButton("�엯�젰");
      btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            getText = textField.getText();
            textArea.append(getText + "\n");
            
            textField.setText("");

            // �옄�룞 �룷而ㅼ뒪 二쇨린
            textField.requestFocus();
            
         }
      });

      btnNewButton_1_1_1_1_1.setBounds(546, 604, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1_1);

//      JLabel lblNewLabel = new JLabel("梨꾪똿諛� �씠由�");
//      lblNewLabel.setBackground(new Color(255, 51, 255));
//      lblNewLabel.setBounds(12, 7, 124, 62);
//      frame.getContentPane().add(lblNewLabel);

      // 諛� �굹媛�湲� ( �눜�옣 )
      JButton btnNewButton_1_1_1_1_2 = new JButton("�눜�옣");
      btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose(); // frame �떕湲�
         }
      });
      btnNewButton_1_1_1_1_2.setBounds(558, 13, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1_2);

      // 梨꾪똿諛� �씠由� : ip 二쇱냼
      JLabel label = new JLabel("梨꾪똿諛� :" + Login.ip);
      label.setBounds(40, 10, 250, 62);
      label.setFont(label.getFont().deriveFont(20.0f));
      frame.getContentPane().add(label);

      // �젅�씠釉�
      JLabel lblNewLabel_1 = new JLabel("李멸��옄 由ъ뒪�듃");
      lblNewLabel_1.setBackground(new Color(255, 51, 255));
      lblNewLabel_1.setBounds(538, 72, 124, 62);
      frame.getContentPane().add(lblNewLabel_1);

      // 李멸��옄 由ъ뒪�듃瑜� 諛쏆븘 �빐�떦 nickName 媛믩뱾�쓣 �븘�씠�뀥�쑝濡� �씠�슜�븳�떎.
      // �셿�꽦�맂 由ъ뒪�듃瑜� 媛��졇���꽌 item�뿉 �꽔�뼱以��떎.

      // 李멸��옄 由ъ뒪�듃 �몴�떆
//      nameList.add(nickName);

//      for (String nickName : PerClinetThread.clientInfo.keySet()) {
//         nameList.add(nickName);
//      }

      System.out.println("�굹 �땳�꽕�엫: " + nickName);
      nameList.add(nickName);

      
      chatList = new String[nameList.size()];
      for (int i = 0; i < nameList.size(); i++) {
         chatList[i] = nameList.get(i);
      }

      chatList = new String[nameList.size()];
      for (int i = 0; i < nameList.size(); i++) {
         System.out.println("�굹 sixTeam �빞");
         chatList[i] = nameList.get(i);
      }

      JList list2 = new JList(chatList);
      list2.setBounds(485, 140, 171, 375);
      frame.getContentPane().add(list2);

      list2.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
               // �뜑釉� �겢由��븳 怨� �씤�뜳�뒪 ���옣.
               int index = list.locationToIndex(evt.getPoint());
               System.out.println(index);
//                  SixTeam_Unicast su = new SixTeam_Unicast(fruits[index], fruits[index].getValue);
               //SixTeam_Unicast su = new SixTeam_Unicast(chatList[index]);
               //su.sixteammain2();

               // �뜑釉뷀겢由��떆, �빐�떦 �씤�뜳�뒪�쓽 jlist媛� 媛�吏�怨� �엳�뒗 媛믪쓣 媛��졇�삩�떎.(�땳�꽕�엫, 洹� �땳�꽕�엫�씠 媛�吏�怨� �엳�뒗 �냼耳�)
               // 洹몃━怨�, �깉濡쒖슫 李쎌씠 �뼚�꽌 �깉濡쒖슫 梨꾪똿�쓣 �떆�옉�븳�떎.
               // �쑀�땲罹먯뒪�똿�쓣 �븷 �닔 �엳�뒗 Thread �몢 媛�, �깉濡쒖슫 �겢�씪�씠�뼵�듃, �깉濡쒖슫 �꽌踰� �깮�꽦�븯湲�
               // UnicastSender, UnicastReceiver, UnicastClient, UnicastServer
            }
         }
      });
      frame.setVisible(true);
      
      
      
      
   }
}