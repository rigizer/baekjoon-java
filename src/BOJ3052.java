import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/3052
public class BOJ3052 {
	public static void main(String[] args) throws Exception {
		List<Integer> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		for (int i: list) {
			int n = i % 42;
			
			if (!temp.contains(n)) {
				temp.add(n);
			}
		}
		
		System.out.println(temp.size());
	}
}
