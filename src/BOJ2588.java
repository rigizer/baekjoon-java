import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2588

public class BOJ2588 {
	private static int get3(String num1, char cNum2) {
		int n1 = Integer.parseInt(num1);
		int n2 = Character.getNumericValue(cNum2);
		
		return n1 * n2;
	}
	
	private static int get4(String num1, char cNum2) {
		int n1 = Integer.parseInt(num1);
		int n2 = Character.getNumericValue(cNum2);
		
		return n1 * n2;
	}
	
	private static int get5(String num1, char cNum2) {
		int n1 = Integer.parseInt(num1);
		int n2 = Character.getNumericValue(cNum2);
		
		return n1 * n2;
	}
	
	private static int get6(String num1, String num2) {
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		
		return n1 * n2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num1 = br.readLine();
		String num2 = br.readLine();
		br.close();
		
		char[] cNum2 = num2.toCharArray();
		
		System.out.println(get3(num1, cNum2[2]));
		System.out.println(get4(num1, cNum2[1]));
		System.out.println(get5(num1, cNum2[0]));
		System.out.println(get6(num1, num2));
	}
}
