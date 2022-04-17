import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13300

public class BOJ13300 {
	private static void input(BufferedReader br, int[][] arr) throws Exception {
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st2.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}
	}
	
	private static int calc(int[][] arr, int m) {
		int result = 0;
		
		int[][] arr2 = new int[6][2];
		for (int[] i: arr) {
			arr2[i[1] - 1][i[0]]++;	// 학년은 1부터, 배열은 0부터 시작하기 때문에 -1
		}
		
		for (int[] i: arr2) {
			for (int j: i) {
				result += j % m == 0 ? j / m : (j / m) + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st1.nextToken());	// 총 학생수
		int m = Integer.parseInt(st1.nextToken());	// 한 방당 최대 인원수
		
		int[][] arr = new int[s][2];
		input(br, arr);
		
		System.out.println(calc(arr, m));
	}
}
