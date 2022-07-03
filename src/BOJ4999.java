import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4999

public class BOJ4999 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String j = br.readLine();
		String d = br.readLine();
		
		int jsize = j.replace("h", "").trim().isEmpty() ? 0 : j.replace("h", "").trim().split("").length;
		int dsize = d.replace("h", "").trim().isEmpty() ? 0 : d.replace("h", "").trim().split("").length;
		
		System.out.println(jsize >= dsize ? "go" : "no");
	}
}
