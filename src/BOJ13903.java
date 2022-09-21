import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13903

public class BOJ13903 {
    static class Node {
        int y;
        int x;
        int step;
        
        public Node(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }
    
    private static int minStep = Integer.MAX_VALUE;
    
    private static int[] dy;
    private static int[] dx;
    
    private static void bfs(int[][] map, boolean[][] visited, int r, int c, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        
        for (int i = 0; i < c; i++) {
            if (map[0][i] == 1) {
                queue.offer(new Node(0, i, 0));
                visited[0][i] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == r - 1) {
                minStep = Math.min(minStep, node.step);
                continue;
            }
            
            for (int d = 0; d < n; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= r || x < 0 || x >= c || visited[y][x] == true || map[y][x] == 0) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.step + 1));
                visited[y][x] = true;
            }
        }
        
        if (minStep == Integer.MAX_VALUE) {
            minStep = -1;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        
        dy = new int[n];
        dx = new int[n];
        for (int d = 0; d < n; d++) {
            st = new StringTokenizer(br.readLine());
            dy[d] = Integer.parseInt(st.nextToken());
            dx[d] = Integer.parseInt(st.nextToken());
        }
        
        bfs(map, visited, r, c, n);
        
        bw.write(String.valueOf(minStep));
        bw.flush();
        bw.close();
        br.close();
    }
}
