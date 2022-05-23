import java.util.Scanner;

// https://www.acmicpc.net/problem/1267

public class Main {
	private static int calc(int n, int m, int[] arr) {
        // 각 통화별로 요금을 별도로 매기는 것에 주의바람.
		int result = 0;
		for (int i: arr) {
			result += ((i / n) * m) + m;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int y = calc(30, 10, arr);
		int m = calc(60, 15, arr);
		
		if (y > m) {
			System.out.println(String.format("M %d", m));
		} else if (y < m) {
			System.out.println(String.format("Y %d", y));
		} else {
			System.out.println(String.format("Y M %d", y));
		}
		
		sc.close();
	}
}
