import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10809

public class BOJ10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] ss = s.toCharArray();
		
		int[] w = new int[26];
		Arrays.fill(w, -1);
		int idx = 0;
		for (char a: ss) {
			int i = Character.getNumericValue(a) - 10;
			if (w[i] != -1) {
				idx++;
				continue;
			}
			
			w[i] = idx;
			idx++;
		}

		for (int a: w) {
			System.out.print(a + " ");
		}
	}
}
