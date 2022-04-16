import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/2635

public class BOJ2635 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 2;
		List<Integer> list = new ArrayList<>();
		
		for (int m = n / 2; m < n; m++) {
			int tempN = n;
			int tempM = m;
			
			List<Integer> tmpList = new ArrayList<>();
			tmpList.add(tempN);
			tmpList.add(tempM);
			
			while(true) {
				int diff = tempN - tempM;
				
				if (tempN - tempM >= 0) {
					tmpList.add(tempN - tempM);
					tempN = tempM;
					tempM = diff;
					continue;
				}
				
				break;
			}
			
			int size = tmpList.size();
			if (size > max) {
				list = tmpList;
				max = size;
			}
		}
		
		System.out.println(max);
		list.stream().forEach(num -> System.out.print(num + " "));;
		
		br.close();
	}
}
