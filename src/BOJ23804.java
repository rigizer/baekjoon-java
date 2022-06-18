import java.util.Scanner;

// https://www.acmicpc.net/problem/23804

public class BOJ23804 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < 5; i++) {
			if (i == 0 || i == 4) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						for (int l = 0; l < 5; l++) {
							System.out.print("@");
						}
					}
					
					System.out.println();
				}
			} else {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						System.out.print("@");
					}
					
					System.out.println();
				}
			}
		}
		
		sc.close();
	}
}
