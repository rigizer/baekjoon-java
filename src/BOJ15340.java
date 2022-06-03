import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15340

public class BOJ15340 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		while (true) {
			int cell = sc.nextInt();
			int data = sc.nextInt();
			
			if (cell == 0 && data == 0) {
				break;
			}
			
			int a = (cell * 30) + (data * 40);
			int b = (cell * 35) + (data * 30);
			int c = (cell * 40) + (data * 20);
			
			list.add(Math.min(Math.min(a, b), c));
		}
		
		list.stream().forEach(i -> System.out.println(i));
		
		sc.close();
	}
}
