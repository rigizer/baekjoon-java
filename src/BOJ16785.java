import java.util.Scanner;

// https://www.acmicpc.net/problem/16785

public class BOJ16785 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();	// 로그인 마다 얻는 코인의 개수
		int b = sc.nextInt();	// 7일 연속 로그인시 얻는 코인의 개수
		int c = sc.nextInt();	// 최소 얻어야 하는 코인의 개수
		
		int resultDay = 0;
		int resultCoin = 0;
		
		while (true) {
			resultDay++;
			
			resultCoin += a;
			if (resultDay % 7 == 0) {
				resultCoin += b;
			}
			
			if (resultCoin >= c) {
				break;
			}
		}
		
		System.out.println(resultDay);
		
		sc.close();
	}
}
