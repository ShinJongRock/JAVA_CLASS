import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class asdf {
	public static void main(String[] args) {
		JFrame  frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel labe = new JLabel("some temx");
		JButton  bt = new JButton("click me");
		JTextArea txtarea = new JTextArea();  //���� �۾� ���
		JPanel btpanl =new JPanel();
		
		
		
		panel.setLayout(new BorderLayout());   //BorderLayout Ư����ġ�� ������ ����
		
		
		btpanl.add(bt);
		
		panel.add(labe, BorderLayout.NORTH);
		panel.add(bt, BorderLayout.WEST); 
		panel.add(txtarea,BorderLayout.CENTER);
		
		
		frame.add(panel);
		
			@Override
			public void 
		
		
		frame.setResizable(false);  //����� ���� �Ҽ� �ֳ�
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9)); //  (���� ������)
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null);  //���â���� ���
		
		
	}
}
