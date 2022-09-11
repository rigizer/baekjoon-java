import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14940

class Node {
    int y;
    int x;
    int t;
    
    public Node(int y, int x, int t) {
        this.y = y;
        this.x = x;
        this.t = t;
    }
}

public class BOJ14940 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static void bfs(int[][] map, int[][] data, boolean[][] visited, int n, int m) {
        Queue<Node> queue = new ArrayDeque<>();
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                    break loop;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= m || map[y][x] == 0 || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1));
                data[y][x] = node.t + 1;
                visited[y][x] = true;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][m];
        int[][] data = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {   // 도달할 수 없는 곳은 -1, 도달하는 경우는 최단거리로 재설정 (BFS)
                    data[i][j] = -1;
                }
            }
        }
        
        bfs(map, data, visited, n, m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}
