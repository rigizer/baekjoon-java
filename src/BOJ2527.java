import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2527

public class BOJ2527 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			int x, y, z, w;
			int xx, yy, zz, ww;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			xx = Integer.parseInt(st.nextToken());
			yy = Integer.parseInt(st.nextToken());
			zz = Integer.parseInt(st.nextToken());
			ww = Integer.parseInt(st.nextToken());
			
			if ((x == zz && w == yy) || (x == zz && y == ww) || (z == xx && y == ww) || (z == xx && w == yy)) {
				System.out.println("c");
			} else if ((z == xx && w != yy) || (x == zz && w != yy) || (z != xx && y == ww) || (x != zz && y == ww)) {
				System.out.println("b");
			} else if (xx > z || yy > w || zz < x || ww < y) {
				System.out.println("d");
			} else {
				System.out.println("a");
			}
		}
	}
}
