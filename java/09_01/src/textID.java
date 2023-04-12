import java.awt.*;
public class textID {
	public static void main(String[] args) {
		Frame f = new Frame("버튼 테스트");
		
		Panel p = new Panel();
		
		TextField tf1 = new TextField("아이디 입력",12);
		TextField tf2 = new TextField("암호 입력",10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
		
	}

}
