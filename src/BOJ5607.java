import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5607

public class BOJ5607 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result_a = 0;
		int result_b = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a > b) {
				result_a += a;
				result_a += b;
			} else if (a < b) {
				result_b += a;
				result_b += b;
			} else {
				result_a += a;
				result_b += b;
			}
		}
		
		System.out.println(result_a + " " + result_b);
		
		br.close();
	}
}
