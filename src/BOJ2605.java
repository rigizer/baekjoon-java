import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2605

public class BOJ2605 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> result = new ArrayList<>();
		int idx = 1;
		for (Integer i: list) {
			result.add(i, idx);
			idx++;
		}
		
		Collections.reverse(result);
		result.stream().forEach(i -> System.out.print(i + " "));
	}
}
