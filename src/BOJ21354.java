import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21354

public class BOJ21354 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) * 7;
		int b = Integer.parseInt(st.nextToken()) * 13;
		
		if (a > b) {
			System.out.println("Axel");
		} else if (a < b) {
			System.out.println("Petra");
		} else {
			System.out.println("lika");
		}
	}
}
