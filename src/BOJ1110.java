import java.util.Scanner;

// https://www.acmicpc.net/problem/1110

public class BOJ1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count = 0;
		int temp = n;
		while (true) {
			count++;
			
			int a = temp / 10;
			int b = temp % 10;
			
			temp = (b * 10) + ((a + b) % 10);
			
			if (temp == n) {
				break;
			}
		}
		
		sc.close();
		System.out.println(count);
	}
}
