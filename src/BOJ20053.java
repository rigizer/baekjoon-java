import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] resArr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			int[] arr = new int[m];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.sort(arr);
			
			resArr[i][0] = arr[0];
			resArr[i][1] = arr[m - 1];
		}
		
		for (int[] i: resArr) {
			System.out.println(String.format("%d %d", i[0], i[1]));
		}
	}
}
