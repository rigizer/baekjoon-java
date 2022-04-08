import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2669

public class BOJ2669 {
	static int[][] arr = new int[101][101];
	
	private static void calc(int x1, int x2, int y1, int y2) {
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				arr[x][y] = 1;
			}
		}
	}
	
	private static int sum() {
		int sum = 0;
		
		for (int x = 0; x <= 100; x++) {
			for (int y = 0; y <= 100; y++) {
				sum += arr[x][y];
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			calc(x1, x2, y1, y2);
		}
		
		br.close();
		System.out.println(sum());
	}
}
