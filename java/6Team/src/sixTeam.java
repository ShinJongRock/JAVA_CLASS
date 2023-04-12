import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Label;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class sixTeam {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sixTeam window = new sixTeam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sixTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\uD83D\uDE04");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		btnNewButton.setBounds(22, 544, 116, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(150, 544, 116, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("2");
		btnNewButton_1_1.setBounds(278, 544, 116, 50);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("3");
		btnNewButton_1_1_1.setBounds(418, 544, 116, 50);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("4");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1.setBounds(546, 544, 116, 50);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(22, 604, 513, 49);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("입력");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(546, 604, 116, 50);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("채팅방 이름");
		lblNewLabel.setBackground(new Color(255, 51, 255));
		lblNewLabel.setBounds(12, 7, 124, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1_1_1_1_2 = new JButton("퇴장");
		btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1_2.setBounds(558, 13, 116, 50);
		frame.getContentPane().add(btnNewButton_1_1_1_1_2);
		
		Label label = new Label("                              ip입력값");
		label.setBounds(124, 23, 410, 23);
		frame.getContentPane().add(label);
		
		//참가자 리스트 표시
		String [] fruits= {"apple", "banana", "kiwi", "mango", "pear", "peach", //접속자 리스트
                "berry", "strawberry", "blackberry"};
		JList list = new JList(fruits);
		list.setBounds(485, 140, 171, 375);
		frame.getContentPane().add(list);
		
		
	      
	      
	   
		//레이블
		JLabel lblNewLabel_1 = new JLabel("참가자 리스트");
		lblNewLabel_1.setBackground(new Color(255, 51, 255));
		lblNewLabel_1.setBounds(538, 72, 124, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 140, 410, 375);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		
	}
}
