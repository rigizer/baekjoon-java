import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/22015

public class BOJ22015 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int max = Math.max(Math.max(a, b), c);
		if (max == a) {
			result = (a - b) + (a - c);
		} else if (max == b) {
			result = (b - a) + (b - c);
		} else {
			result = (c - a) + (c - b);
		}
		
		System.out.println(result);
	}
}
