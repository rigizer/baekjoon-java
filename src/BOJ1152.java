import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1152

public class BOJ1152 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int result = line.trim().isEmpty() ? 0 : line.trim().split(" ").length;
		System.out.println(result);
	}
}
