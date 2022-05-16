import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10871

public class BOJ10871 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int max = Integer.parseInt(st1.nextToken());
		
		List<Integer> numArr = new ArrayList<>(); 
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(st2.nextToken());
			numArr.add(m);
		}
		
		List<Integer> resultArr = new ArrayList<>();
		for (int i: numArr) {
			if (i < max) {
				resultArr.add(i);
			}
		}
		
		for (int i: resultArr) {
			System.out.print(i + " ");
		}
	}
}
