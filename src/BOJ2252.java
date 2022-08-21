import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2252

public class BOJ2252 {
    static List<List<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        int n = Integer.parseInt(st.nextToken());   // 학생 수
        int m = Integer.parseInt(st.nextToken());   // 키 비교 횟수
        boolean[] visited = new boolean[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 데이터 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            graph.get(front).add(back);
            indegree[back]++;
        }
        
        // 초기 Queue 할당값 지정
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                if (indegree[graph.get(now).get(i)] == 0) {
                    queue.offer(graph.get(now).get(i));
                }
            }
        }
    }
}
