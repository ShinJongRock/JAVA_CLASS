import java.util.Arrays;
import java.util.Scanner;

public class Test_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int cont = sc.nextInt();
		int[] arr = new int[cont];
		
		
		for (int i = 0; i < cont; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		
		int max = arr[cont-1];
		
		int min =arr[0];
		
		System.out.println(max*min);

	}

}
