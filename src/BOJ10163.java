import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10163

public class BOJ10163 {
	public static void main(String[] args) throws Exception {
		int[][] square = new int[1001][1001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// n번의 사각형 좌표 및 넓이 데이터를 입력받음
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 각 좌표, 넓이별 색종이 데이터에 대해 덮어씌움 (겹치기)
			for (int x = x1; x < x1 + x2; x++) {
				for (int y = y1; y < y1 + y2; y++) {
					square[x][y] = i;
				}
			}
		}
		
		// n개의 배열 할당
		int[] idx = new int[n];
		
		// 브루트포스 방식으로 데이터 확인
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				int value = square[i][j];
				
				// 데이터가 0(초기값)이 아닌이상 해당 데이터는 색종이라고 간주
				if (value != 0) {
					idx[value - 1]++;
				}
			}
		}
		
		// 배열에 있는 색종이 넓이정보를 출력
		for (int i: idx) {
			System.out.println(i);
		}
	}
}
