import java.util.Scanner;

// https://www.acmicpc.net/problem/23795

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			int temp = sc.nextInt();
			if (temp == -1) {
				break;
			}
			
			sum += temp;
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
