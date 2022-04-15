import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2628

public class BOJ2628 {
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
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(st2.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}
		
		// 가로 및 세로 최대값을 저장할 공간을 할당한다
		int garoMax = 0;
		int seroMax = 0;
		
		// 각각의 가로 넓이들을 구한다
		List<Integer> widthMax = new ArrayList<>();
		int widthTemp = 0;
		for (int i = 0; i < w; i++) {
			if (i == arr[i][0]) {
				widthMax.add(widthTemp - i);
				widthTemp = arr[i][0];
			}
		}
		
		// 각각의 세로 넓이들을 구한다
		List<Integer> heightMax = new ArrayList<>();
		int heightTemp = 0;
		for (int i = 0; i < h; i++) {
			if (i == arr[i][0]) {
				heightMax.add(heightTemp - i);
				heightTemp = arr[i][1];
			}
		}
		
		// 가로, 세로의 최대값을 구한다
		garoMax = Collections.max(widthMax);
		seroMax = Collections.max(heightMax);
		
		// 가로 * 세로, 즉 넓이를 출력한다
		bw.write(String.valueOf(garoMax * seroMax));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
