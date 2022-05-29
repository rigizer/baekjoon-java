import java.math.BigInteger;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2338

public class BOJ2338 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		
		sc.close();
	}
}
