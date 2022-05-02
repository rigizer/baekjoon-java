import java.util.Scanner;

// https://www.acmicpc.net/problem/2960

public class BOJ2960 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int result = 0;
		
		int[] arr = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		
		int idx = 0;
		loop:
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				continue;
			}
			
			for (int j = i; j <= n; j++) {
				if (arr[j] == 0) {
					continue;
				}
				
				if (arr[j] % i == 0) {
					idx++;
					
					if (idx == k) {
						result = arr[j];
						break loop;
					}
					
					arr[j] = 0;
				}
			}
		}
		
		System.out.println(result);
	}
}
