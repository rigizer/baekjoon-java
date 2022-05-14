import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/24783

public class BOJ24783 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Boolean> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a + b == c
				|| a - b == c
				|| b - a == c
				|| a * b == c
				|| (a / b == c) && (a % b == 0)
				|| (b / a == c) && (b % a == 0)
			) {
				list.add(true);
			} else {
				list.add(false);
			}
		}
		
		for (boolean b: list) {
			String s = b ? "Possible" : "Impossible";
			System.out.println(s);
		}
	}
}
