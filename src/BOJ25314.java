import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25314

public class BOJ25314 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()) / 4;
		for (int i = 0; i < n; i++) {
			System.out.print("long ");
		}
		
		System.out.println("int");
		
		br.close();
	}
}
