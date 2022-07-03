import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4999

public class BOJ4999 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int j = br.readLine().length();
		int d = br.readLine().length();
		
		System.out.println(j >= d ? "go" : "no");
	}
}
