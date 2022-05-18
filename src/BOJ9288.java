import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9288

public class BOJ9288 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		// 총 케이스 수
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());	// 각 케이스별 확인할 숫자 입력
			System.out.println(String.format("Case %d:", i + 1));
			for (int x = 1; x <= 6; x++) {			// x를 1부터 시작하여 오름차순
				for (int y = x; y <= 6; y++) {		// y를 x부터 시작하여 중복방지
					if (x + y == num) {
						System.out.println(String.format("(%d,%d)", x, y));
					}
				}
			}
		}
	}
}
