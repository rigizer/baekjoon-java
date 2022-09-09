import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012

class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ1012 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int bfs(int y_max, int x_max, int[][] map, boolean[][] visited) {
        int result = 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < y_max; i++) {
            for (int j = 0; j < x_max; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    result++;
                }
                
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    
                    for (int d = 0; d < 4; d++) {
                        int y = node.y + dy[d];
                        int x = node.x + dx[d];
                        
                        if (y < 0 || y >= y_max || x < 0 || x >= x_max || map[y][x] == 0 || visited[y][x] == true) {
                            continue;
                        }
                        
                        queue.offer(new Node(y, x));
                        visited[y][x] = true;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                map[y][x] = 1;
            }
            
            int result = bfs(n, m, map, visited);
            System.out.println(String.format("%d", result));
        }
    }
}
