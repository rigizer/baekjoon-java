import java.util.Scanner;

// https://www.acmicpc.net/problem/6321

public class BOJ6321 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			System.out.println("String #"+(i + 1));
			
			for (int j = 0; j < str.length(); j++) {
				char s = str.charAt(j);
				s += 1;
				
				if (s == 91) {
					s = 65;
				}
				
				System.out.print(s);
			}
			
			System.out.println();
			System.out.println();
		}
		
		sc.close();
	}
}
