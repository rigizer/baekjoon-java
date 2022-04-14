import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2491

public class BOJ2491 {
	private static int forward(int n, int[] num) {
		int max = 0;
		int temp = 0;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			if (temp <= num[i]) {
				temp = num[i];
				count++;
				
				if (count >= max) {
					max = count;
				}
				continue;
			}
			
			temp = num[i];
			count = 1;
		}
		
		return max;
	}
	
	private static int backward(int n, int[] num) {
		int max = 0;
		int temp = 0;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			if (temp >= num[i]) {
				temp = num[i];
				count++;
				
				if (count >= max) {
					max = count;
				}
				continue;
			}
			
			temp = num[i];
			count = 1;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int f = forward(n, num);
		int b = backward(n, num);
		
		System.out.println(f >= b ? f : b);
		
		br.close();
	}
}
