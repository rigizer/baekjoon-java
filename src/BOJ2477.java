import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2477

public class BOJ2477 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int min = 0;
		int idx = 0;
		
		for (int i = 0; i < 6; i++) {
			int tmp = arr[i] * arr[(i + 1) % 6];
			if (max < tmp) {
				max = tmp;
				idx = i;
			}
		}
		
		min = arr[(idx + 3) % 6] * arr[(idx + 4) % 6];
		System.out.println((max - min) * n);
	}
}
