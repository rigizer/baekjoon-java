import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2869

public class BOJ2869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int up = 0;
		int day = 0;
		while (true) {
			day++;
			
			up += a;
			
			if (up >= v) {
				break;
			}
			
			up -= b;
			
			if (up >= v) {
				break;
			}
		}
		
		System.out.println(day);
	}
}
