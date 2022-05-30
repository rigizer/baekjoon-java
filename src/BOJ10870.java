import java.util.Scanner;

// https://www.acmicpc.net/problem/10870

public class BOJ10870 {
	private static int recursive(int before, int next, int turn, int maxTurn) {
		if (turn == maxTurn) {
			return before;
		}
		
		int temp = before;
		before = next;
		next = temp + next;
		
		return recursive(before, next, ++turn, maxTurn);
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(recursive(0, 1, 0, n));
		
		sc.close();
	}
}
