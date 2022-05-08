import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773

public class BOJ10773 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int nn = Integer.parseInt(br.readLine());
			
			if (nn == 0) {
				stack.pop();
				continue;
			}
			
			stack.push(nn);
		}
		
		int result = stack.stream().mapToInt(Integer::intValue).sum();
		System.out.println(result);
	}
}
