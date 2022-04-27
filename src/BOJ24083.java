import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/24083

public class BOJ24083 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		n = (n + t) % 12;
		System.out.println(n == 0 ? 12 : n);
	}
}
