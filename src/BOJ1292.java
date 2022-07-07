import java.util.Scanner;

class BOJ1292
{
	private static int get_sum(int a, int b) {
		int n = 0;
		int i = 0;
		
		int sum = 0;
		
		while (true) {
			n++;
			
			for (int t = 0; t < n; t++) {
				i++;
				
				if (a <= i && i <= b) {
					sum += n;
				}
				
				
				
				if (i > b) {
					return sum;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sum = get_sum(a, b);
		
		System.out.println(sum);
	}
}
