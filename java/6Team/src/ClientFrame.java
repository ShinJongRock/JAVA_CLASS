import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Id extends JFrame implements ActionListener{
	static JTextField tf=new JTextField(8);
	JButton btn = new JButton("입력");	
	
	WriteThread wt;	
	ClientFrame cf;
	public Id(){}
	public Id(WriteThread wt, ClientFrame cf) {
		super("아이디");		
		this.wt = wt;
		this.cf = cf;
		
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(300, 300, 250, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {		
		wt.sendMsg();	
		cf.isFirst = false;
		cf.setVisible(true);
		this.dispose();
	}
	static public String getId(){
		return tf.getText();
	}
}




public class ClientFrame extends JFrame implements ActionListener{
	JTextArea txtA = new JTextArea();
	JTextField txtF = new JTextField(15);
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("닫기");
	
	JButton emoji1 =new JButton("😄");
	JButton emoji2 =new JButton("😑");
	JButton emoji3 =new JButton("😡");
	JButton emoji4 =new JButton("😥");
	JButton emoji5 =new JButton("😛");
	
	
	boolean isFirst=true;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Socket socket;
	WriteThread wt;
	
	
	
	public ClientFrame(Socket socket) {
		super("채팅");
		this.socket = socket;
		wt = new WriteThread(this);
		new Id(wt, this);
		
		add("Center", txtA);
		
		
		p1.add(txtF);
		p2.add(emoji1);
		p2.add(emoji2);
		p2.add(emoji3);
		p2.add(emoji4);
		p2.add(emoji5);
		
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South", p2);
		p2.add(p1);
		
		
		//메세지를 전송하는 클래스 생성.
		emoji1.addActionListener(this);
		emoji2.addActionListener(this);
		emoji3.addActionListener(this);
		emoji4.addActionListener(this);
		emoji5.addActionListener(this);
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 700,  500, 500);
		setVisible(false);	
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		String id = Id.getId();
		
		if(e.getSource() == emoji1 ) { //전송버튼 눌렀을 경우
			if(txtF.getText().equals("")){//메세지 입력없이 전송버튼만 눌렀을 경우
				return;
			}		
			txtA.append("["+id+"] "+ txtF.getText()+"\n"+"시간");
			wt.sendMsg();
			txtF.setText("");
	
		}
		
		
		if(e.getSource()==btnTransfer){//전송버튼 눌렀을 경우
			//메세지 입력없이 전송버튼만 눌렀을 경우
			if(txtF.getText().equals("")){
				return;
			}			
			txtA.append("["+id+"] "+ txtF.getText() + "시간"+"\n");
			wt.sendMsg();
			txtF.setText("");
			
		}else{
			this.dispose();
		}
	}
}
