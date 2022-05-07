import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4153

public class BOJ4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<>();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			
      // a, b, c가 고정되어있지 않음에 주의
			if ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) && (a + b > c)
					|| (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) && (b + c > a)
					|| (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) && (a + c > b)) {
				result.add("right");
			} else {
				result.add("wrong");
			}
		}
		
		result.stream().forEach(i -> System.out.println(i));
	}
}
