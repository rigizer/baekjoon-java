import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2753

public class BOJ2753 {
	private static int calcYear(int y) {
		if ((y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0))) {
			return 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int y = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(calcYear(y));
	}
}
