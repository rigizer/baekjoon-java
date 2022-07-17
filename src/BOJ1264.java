import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1264

public class BOJ1264 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String s = br.readLine();
			int t = 0;
			
			if (s.equals("#")) {
				break;
			}
			
			char[] c = s.toCharArray();
			for (char i: c) {
				switch(i) {
				case 'A': case 'a':
				case 'E': case 'e':
				case 'I': case 'i':
				case 'O': case 'o':
				case 'U': case 'u':
					t++;
					break;
				}
			}
			
			System.out.println(t);
		}
		
		br.close();
	}
}
