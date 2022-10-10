import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/23352

public class BOJ23352 {
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
    
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int maxDist = Integer.MIN_VALUE;
    private static int maxSum = Integer.MIN_VALUE;
    
    private static void bfs(int[][] board, int n, int m, int i, int j) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new Node(i, j, 0));
        visited[i][j] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (maxDist < node.t) {
                maxDist = node.t;
                maxSum = board[i][j] + board[node.y][node.x];
            } else if (maxDist == node.t) {
                maxSum = Math.max(maxSum, board[i][j] + board[node.y][node.x]);
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= m || board[y][x] == 0 || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1));
                visited[y][x] = true;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    bfs(board, n, m, i, j);
                }
            }
        }
        
        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
