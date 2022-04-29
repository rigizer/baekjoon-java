import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/24904

public class BOJ24904 {
	public static void main(String[] args) throws Exception {
		List<String> words = new ArrayList<>();
		
		File file = new File("C:\\Users\\User\\Documents\\git\\baekjoon-java\\src\\wordle.txt");
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while((line = bufReader.readLine()) != null){
        	char[] l = line.toCharArray();
        	
        	// 자리 일치여부 확인
        	if (Character.compare(l[1], 'A') != 0) {
        		continue;
        	}
        	
        	/*
        	if (Character.compare(l[0], 'R') == 0) {
        		continue;
        	}
        	*/
        	
        	// 위치는 다르지만 포함하는 문자
        	if (!line.contains("G")) {
        		continue;
        	}
        	
        	if (!line.contains("L")) {
        		continue;
        	}
        	
        	if (!line.contains("U")) {
        		continue;
        	}
        	
        	
        	// 포함하면 안되는 문자
        	if (line.contains("B")) {
        		continue;
        	}
        	
        	if (line.contains("C")) {
        		continue;
        	}
        	
        	if (line.contains("D")) {
        		continue;
        	}
        	
        	if (line.contains("E")) {
        		continue;
        	}
        	
        	if (line.contains("I")) {
        		continue;
        	}
        	
        	if (line.contains("M")) {
        		continue;
        	}
        	
        	if (line.contains("N")) {
        		continue;
        	}
        	
        	if (line.contains("O")) {
        		continue;
        	}
        	
        	if (line.contains("R")) {
        		continue;
        	}
        	
        	if (line.contains("T")) {
        		continue;
        	}
        	
        	if (line.contains("Y")) {
        		continue;
        	}
        	
        	// 모든 조건을 만족한 단어
            words.add(line);
        }
        bufReader.close();
        
        System.out.println(words);
	}
}
