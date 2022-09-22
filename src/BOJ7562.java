import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7562

public class BOJ7562 {
    static class Node {
        int y;
        int x;
        int t;
        
        public Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    
    private static int sy, sx, ey, ex;
    
    private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    
    private static int bfs(int[][] board, int s) {
        int result = Integer.MAX_VALUE;
        
        boolean[][] visited = new boolean[s][s];
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(sy, sx, 0));
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == ey && node.x == ex) {
                return node.t;
            }
            
            for (int d = 0; d < 8; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= s || x < 0 || x >= s || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1));
                visited[y][x] = true;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int s = Integer.parseInt(br.readLine());
            int[][] board = new int[s][s];
            st = new StringTokenizer(br.readLine());
            sy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            ey = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            
            int result = bfs(board, s);
            sb.append(String.valueOf(result));
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
