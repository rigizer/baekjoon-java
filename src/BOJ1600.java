import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1600

public class BOJ1600 {
    static class Node {
        int y;
        int x;
        int t;
        int k;
        
        Node(int y, int x, int t, int k) {
            this.y = y;
            this.x = x;
            this.t = t;
            this.k = k;
        }
    }
    
    private static int[] dyp = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dxp = {1, 2, 2, 1, -1, -2, -2, -1};
    
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int bfs(int[][] map, boolean[][][] visited, int w, int h, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == h - 1 && node.x == w - 1) {
                return node.t;
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= h || x < 0 || x >= w || map[y][x] == 1 || visited[node.k][y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1, node.k));
                visited[node.k][y][x] = true;
            }
            
            if (node.k + 1 <= k) {
                for (int d = 0; d < 8; d++) {
                    int y = node.y + dyp[d];
                    int x = node.x + dxp[d];
                    
                    if (y < 0 || y >= h || x < 0 || x >= w || map[y][x] == 1 || visited[node.k + 1][y][x] == true) {
                        continue;
                    }
                    
                    queue.offer(new Node(y, x, node.t + 1, node.k + 1));
                    visited[node.k + 1][y][x] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int k = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[h][w];
        boolean[][][] visited = new boolean[k + 1][h][w];
        
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = bfs(map, visited, w, h, k);
        System.out.println(result);
    }
}
