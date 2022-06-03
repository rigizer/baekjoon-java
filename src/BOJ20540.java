import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/20540

public class BOJ20540 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		String s = sc.next();
		String[] c = s.split("");
		
		for (String cc: c) {
			switch(cc) {
			case "I":	list.add("E");	break;
			case "E":	list.add("I");	break;
			case "S":	list.add("N");	break;
			case "N":	list.add("S");	break;
			case "T":	list.add("F");	break;
			case "F":	list.add("T");	break;
			case "J":	list.add("P");	break;
			case "P":	list.add("J");	break;
			}
		}
		
		list.stream().forEach(i -> System.out.print(i));
		
		sc.close();
	}
}
