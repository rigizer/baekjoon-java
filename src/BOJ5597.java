import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/5597

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();		
		for (int i = 1; i <= 28; i++) {
			int temp = sc.nextInt();
			list.add(temp);
		}
		
		for (int i = 1; i <= 30; i++) {
			if (!list.contains(i)) {
				System.out.println(i);
			}
		}
		
		sc.close();
	}
}
