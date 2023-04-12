import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterEx extends Frame implements ActionListener {
	Panel p1, p2, p3;
	TextField tf;
	TextArea ta;

	Button b1, b2;

	class KeyEventHandler extends KeyAdapter {

		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
		}
	}

	public AdapterEx() {
		super("Adapter");

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		tf = new TextField(35);
		ta = new TextArea(10, 35);
		b1 = new Button("Clear");
		b2 = new Button("Exit");

		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add("North", p1);
		add("Center", p2);
		add("South", p3);

		b1.addActionListener(this);
		b2.addActionListener(this);

		tf.addKeyListener(new KeyEventHandler()); // 외부에 있는거 불러옴
//	      addWindowListener(new WindowEventHandler());		//외부에 있는거 불러옴

		setBounds(300, 300, 300, 200);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Clear")) {
			ta.setText("");
			tf.setText("");
			tf.requestFocus();
		} else if (str.equals("Exit")) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new AdapterEx();
	}
}
//	   
//	   	// 맴버이너 클래스
//	   class KeyEventHandler extends KeyAdapter {
//	      TextField tf;
//	      TextArea ta;
//
//	      public KeyEventHandler(TextField tf, TextArea ta) {
//	         this.tf = tf;
//	         this.ta = ta;
//	      }
//
//	      public void keyTyped(KeyEvent e) {
//	         if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//	            ta.append(tf.getText() + "\n");
//	            tf.setText("");
//	         }
//	      }
//	   }

//	//어나니머스 이너 클래스
//	class WindowEventHandler extends WindowAdapter {
//	   public void windowClosing(WindowEvent e) {
//	      System.exit(0);
//	   }
//	}