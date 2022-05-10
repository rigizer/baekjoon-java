import java.util.Scanner;

// https://www.acmicpc.net/problem/17826

public class BOJ17826 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[50];
		for (int i = 0; i < 50; i++) {
			arr[i] = sc.nextInt();
		}
		
		int n = sc.nextInt();
		int idx = 0;
		for (int i = 0; i < 50; i++) {
			if (arr[i] == n) {
				idx = i;
				break;
			}
		}
		
		switch(idx / 5) {
		case 0:
			System.out.println("A+");
			break;
		case 1:
		case 2:
			System.out.println("A0");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("B+");
			break;
		case 6:
			System.out.println("B0");
			break;
		case 7:
		case 8:
			System.out.println("C+");
			break;
		case 9:
			switch(idx + 1) {
			case 46:
			case 47:
			case 48:
				System.out.println("C0");
				break;
			case 49:
			case 50:
				System.out.println("F");
				break;
			}
			break;
		}
		
		sc.close();
	}
}
