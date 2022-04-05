import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/18108

public class BOJ18108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int y = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(y - 543);
	}
}
