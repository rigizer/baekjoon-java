import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697

class Node {
    int x;
    int t;
    
    public Node(int x, int t) {
        this.x = x;
        this.t = t;
    }
}

public class Main {
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[] visited = new boolean[100001]; // 100,000도 포함이므로 크기가 100,001
    static int sx, ex;
    
    private static int bfs() {
        int result = 0;
        
        queue.offer(new Node(sx, 0));
        visited[sx] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == ex) {
                return node.t;
            }
            
            int dx[] = {node.x, -1, 1};
            
            for (int d = 0; d < 3; d++) {
                int x = node.x + dx[d];
                
                if (x < 0 || x >= 100001 || visited[x] == true) {
                    continue;
                }
                
                queue.offer(new Node(x, node.t + 1));
                visited[x] = true;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        sx = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
    }
}
