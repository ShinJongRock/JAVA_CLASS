import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent Text");

		p = new Panel();

		input = new Button("�Է�");
		exit = new Button("����");
		ta = new TextArea();

		input.addActionListener(this); // �̺�Ʈ�� �ڵ鷯 ����
		exit.addActionListener(this);
		addWindowListener(this);

		p.add(input);
		p.add(exit);

		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		setBounds(300, 300, 300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String name;
		name = ae.getActionCommand();

		if (name.equals("�Է�"))
			ta.append("��ư�� �ԷµǾ����ϴ�\n");
		else {
			ta.append("���α׷��� �����մϴ�.\n");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionEventEx();

	}

	public void windowClosing1(WindowEvent e) {
		System.exit(0);
		

		// �����ӿ� ������ �Է�???
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
