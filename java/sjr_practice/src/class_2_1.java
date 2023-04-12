
//원화를 입력하세요(단위 원) >> 3300
//3300원은 $3.0입니다.
import java.util.Scanner;
public class class_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("원화를 입력하세요(단위:원)>>");
		int num=s.nextInt();
		double dollar=num/1100;
		System.out.println(num+"원은 $"+dollar+"입니다.");
		s.close();
	}

}
