import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2468

class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ2468 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static void visited_clear(boolean[][] visited, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
    
    private static void bfs(int[][] map, boolean[][] visited, int n, int h, int i, int j) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(i, j));
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= n || map[y][x] <= h || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x));
                visited[y][x] = true;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(map[i][j], max_height);
            }
        }
        
        int max_count = 0;
        for (int h = 0; h <= max_height; h++) { // 각 높이별로 모든 경우의 수를 확인해야 한다.
            int count = 0;
            visited_clear(visited, n);  // 높이가 달라질 때 마다 visited를 초기화 해야 한다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && visited[i][j] == false) {
                        bfs(map, visited, n, h, i, j);
                        count++;
                    }
                }
            }
            
            max_count = Math.max(count, max_count);
        }
        
        System.out.println(max_count);
    }
}
