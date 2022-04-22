import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2563

public class BOJ2563 {
	public static void main(String[] args) throws Exception {
		int[][] square = new int[101][101];
		int count = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		for (int[] i: arr) {
			int x1 = i[0];
			int x2 = i[0] + 10;
			int y1 = i[1];
			int y2 = i[1] + 10;
			
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					square[x][y] = 1;
				}
			}
		}
		
		for (int x = 0; x < square.length; x++) {
			for (int y = 0; y < square[0].length; y++) {
				if (square[x][y] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
