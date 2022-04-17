import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2628

public class BOJ2628 {
	private static int calc(List<Integer> list) {
		int tmp = 0;
		int max = 0;
		for (Integer i: list) {
			int diff = Math.abs(tmp - i);
			max = Math.max(diff, max);
			tmp = i;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 가로, 세로 크기를 입력받는다
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st1.nextToken());
		int h = Integer.parseInt(st1.nextToken());
		
		// 자를 횟수를 입력받는다
		int n = Integer.parseInt(br.readLine());
		
		// 어디를 자를지 입력받는다
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st2.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}
		
		// 가로로 잘라야 하는 좌표를 리스트화 한다 (세로좌표)
		List<Integer> garoList = new ArrayList<>();
		garoList.add(0);
		garoList.add(h);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				garoList.add(arr[i][1]);
			}
		}
		Collections.sort(garoList);
		
		// 세로로 잘라야 하는 좌표를 리스트화 한다 (가로좌표)
		List<Integer> seroList = new ArrayList<>();
		seroList.add(0);
		seroList.add(w);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 1) {
				seroList.add(arr[i][1]);
			}
		}
		Collections.sort(seroList);
		
		int garoMax = calc(garoList);
		int seroMax = calc(seroList);
		
		// 가로 * 세로, 즉 넓이를 출력한다
		bw.write(String.valueOf(garoMax * seroMax));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
