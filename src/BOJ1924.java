import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1924

public class BOJ1924 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int sum = 0;
		for (int i = 0; i < x; i++) {
			if (i == x - 1) {
				sum += y;
			} else {
				sum += arr[i];
			}
		}
		
		String today;
		switch(sum % 7) {
		case 0:
			today = "SUN";
			break;
		case 1:
			today = "MON";
			break;
		case 2:
			today = "TUE";
			break;
		case 3:
			today = "WED";
			break;
		case 4:
			today = "THU";
			break;
		case 5:
			today = "FRI";
			break;
		case 6:
			today = "SAT";
			break;
		default:
			today = "";
			break;
		}
		
		System.out.println(today);
	}
}
