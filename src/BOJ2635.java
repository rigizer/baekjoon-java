import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// https://www.acmicpc.net/problem/2635

public class BOJ2635 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rd = new Random();
		
		//int n = Integer.parseInt(br.readLine());
		int n = 100;
		int m = rd.nextInt(n);
		int idx = 2;
		
		List<Integer> list = new ArrayList<>();
		list.add(n);
		list.add(m);
		
		while(true) {
			int diff = n - m;
			
			if (n - m > 0) {
				list.add(n - m);
				n = m;
				m = diff;
				idx++;
				continue;
			}
			
			break;
		}
		
		System.out.println(idx);
		list.stream().forEach(num -> System.out.print(num + " "));;
		
		br.close();
	}
}
