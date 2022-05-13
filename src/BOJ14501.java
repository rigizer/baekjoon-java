import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14501

public class BOJ14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			arr[i][0] = t;
			arr[i][1] = p;
		}
		
		List<Integer> list = new ArrayList<>();
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			int nextIdx = i;
			for (int j = i; j < n; j++) {
				if (nextIdx > j) {
					continue;
				}
				
				nextIdx = j + arr[j][0];
				
				if (nextIdx > n + 1) {
					break;
				}
				
				result += arr[j][1];
			}
			
			list.add(result);
			result = 0;
		}
		
		result = Collections.max(list);
		System.out.println(result);
	}
}
