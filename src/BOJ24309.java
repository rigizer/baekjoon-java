import java.math.BigInteger;
import java.util.Scanner;

// https://www.acmicpc.net/problem/24309

public class BOJ24309 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger c = sc.nextBigInteger();
		
		BigInteger x = (b.subtract(c)).divide(a);
		
		System.out.println(x);
		
		sc.close();
	}
}
