import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2578

public class BOJ2578 {
	static int[][] c_arr = new int[5][5];	// 철수 번호 입력
	static int[][] m_arr = new int[5][5];	// 사회자 번호 입력
	static int[][] b_arr = new int[5][5];	// 빙고 체크
	
	// 배열에 숫자 입력
	private static int[][] inputNumber(BufferedReader br) throws Exception {
		int[][] arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		return arr;
	}
	
	// 사회자가 부른 숫자에 해당하는 숫자 확인
	private static void updateN(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (c_arr[i][j] == n) {
					b_arr[i][j] = 1;
				}
			}
		}
	}
	
	// 빙고 체크
	private static int checkBingo(int n) {
		updateN(n);
		
		int bingoLine = 0;
		int idx = 0;
		
		// 가로줄 빙고확인
		for (int i = 0; i < 5; i++) {
			idx = 0;
			
			for (int j = 0; j < 5; j++) {
				if (b_arr[i][j] == 1) {
					idx++;
				}
			}
			
			if (idx == 5) {
				bingoLine++;
			}
		}
		
		// 세로줄 빙고확인
		for (int j = 0; j < 5; j++) {
			idx = 0;
			
			for (int i = 0; i < 5; i++) {
				if (b_arr[i][j] == 1) {
					idx++;
				}
			}
			
			if (idx == 5) {
				bingoLine++;
			}
		}
		
		
		// 좌상우하 대각선확인
		idx = 0;
		
		for (int i = 0; i < 5; i++) {
			if (b_arr[i][i] == 1) {
				idx++;
			}
		}
		
		if (idx == 5) {
			bingoLine++;
		}
		
		// 좌하우상 대각선확인
		idx = 0;
		
		for (int i = 4; i >= 0; i--) {
			if (b_arr[i][4 - i] == 1) {
				idx++;
			}
		}
		
		if (idx == 5) {
			bingoLine++;
		}
		
		return bingoLine;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c_arr = inputNumber(br);
		m_arr = inputNumber(br);
		
		int idx = 0;
		loopOut:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				idx++;
				int n = m_arr[i][j];
				
				int bingoLine = checkBingo(n);
				
				if (bingoLine >= 3) {
					break loopOut;
				}
			}
		}
		
		System.out.println(idx);
		
		br.close();
	}
}
