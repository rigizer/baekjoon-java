import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10807

public class BOJ10807 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			list.add(temp);
		}
		
		int m = sc.nextInt();
		
		for (int i: list) {
			if (i == m) {
				result++;
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
