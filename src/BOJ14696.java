import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14696

public class BOJ14696 {
	private static int[] inputArr(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[4];
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[temp - 1]++;
		}
		
		return arr;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int roundMax = Integer.parseInt(br.readLine());
		
		
		List<String> list = new ArrayList<>();
		for (int round = 0; round < roundMax; round++) {
			int[] arrA = inputArr(br);
			int[] arrB = inputArr(br);
			
			boolean aWin = false;
			boolean bWin = false;
			
			if (arrA[3] != arrB[3]) {				// 별의 개수가 다른경우
				if (arrA[3] > arrB[3]) {			// A의 별이 더 많은경우
					aWin = true;
				} else {							// B의 별이 더 많은경우
					bWin = true;
				}
			} else {								// 별의 개수가 같은경우
				if (arrA[2] != arrB[2]) {			// 동그라미의 개수가 다른경우
					if (arrA[2] > arrB[2]) {		// A의 동그라미가 더 많은경우
						aWin = true;
					} else {						// B의 동그라미가 더 많은경우
						bWin = true;
					}
				} else {							// 동그라미의 개수가 같은경우
					if (arrA[1] != arrB[1]) {		// 네모의 개수가 다른경우
						if (arrA[1] > arrB[1]) {	// A의 네모가 더 많은경우
							aWin = true;
						} else {					// B의 네모가 더 많은경우
							bWin = true;
						}
					} else {						// 네모의 개수가 같은경우
						if (arrA[0] != arrB[0]) {	// 세모의 개수가 다른경우
							if (arrA[0] > arrB[0]) {// A의 세모가 더 많은경우
								aWin = true;
							} else {				// B의 세모가 더 많은경우
								bWin = true;
							}
						}
					}
				}
			}
			
			if (aWin == true && bWin == false) {
				list.add("A");	// A의 승리
			} else if (aWin == false && bWin == true) {
				list.add("B");	// B의 승리
			} else {
				list.add("D");	// 무승부
			}
		}
		
		for (String s: list) {
			System.out.println(s);
		}
		
		br.close();
	}
}
