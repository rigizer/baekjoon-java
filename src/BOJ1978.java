import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1978

public class BOJ1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(st.nextToken());
			list.add(m);
		}
		
		// 확인 가능한 최대 소수
		int max = Collections.max(list);
		
		// 소수 리스트
		List<Integer> sList = new ArrayList<>();
		
		// 소수 체크
		for (int i = 2; i <= max; i++) {
			if (i < 1) {
				continue;
			}
			
			if (i != 2 && i % 2 == 0) {
				continue;
			}
			
			int temp = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					temp++;
				}
			}
			
			if (temp == 2) {
				sList.add(i);
			}
		}
		
		// 입력받은 값과 소수 리스트 비교
		for (int i: list) {
			for (int j: sList) {
				if (i > j) {
					continue;
				}
				
				if (i < j) {
					break;
				}
				
				if (i == j) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}
