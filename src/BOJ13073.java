import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/13073

public class BOJ13073 {
	private static int getS1(int m) {
		int s1 = 0;
		int lastNum = 1;
		
		for (int i = 0; i < m; i++) {
			s1 += lastNum;
			lastNum++;
		}
		
		return s1;
	}
	
	private static int getS2(int m) {
		int s2 = 0;
		int lastNum = 1;
		
		for (int i = 0; i < m; i++) {
			s2 += lastNum;
			lastNum += 2;
		}
		
		return s2;
	}
	
	private static int getS3(int m) {
		int s3 = 0;
		int lastNum = 2;
		
		for (int i = 0; i < m; i++) {
			s3 += lastNum;
			lastNum += 2;
		}
		
		return s3;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			
			int s1 = getS1(m);
			int s2 = getS2(m);
			int s3 = getS3(m);
			
			list.add(String.format("%d %d %d", s1, s2, s3));
		}
		
		list.stream().forEach(i -> System.out.println(i));
	}
}
