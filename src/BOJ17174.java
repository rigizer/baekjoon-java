import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17174

public class BOJ17174 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int tempTotal = n;
		int count = n;
		
		while(true) {
			int a = tempTotal / m;
			count += a;
			if (a / m > 0) {
				tempTotal = a;
				continue;
			}
			
			break;
		}
		
		System.out.println(count);
	}
}
