import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3055

public class BOJ3055 {
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
    
    private static void init_water(int r, int c, char[][] board, Queue<Node> queue, int[][] visited) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = Integer.MAX_VALUE;
                
                if (board[i][j] == '*') {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = 0;
                }
            }
        }
    }
    
    private static int[][] bfs_water(int r, int c, char[][] board) {
        Queue<Node> queue = new ArrayDeque<>();
        int visited[][] = new int[r][c];
        
        init_water(r, c, board, queue, visited);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= r || x < 0 || x >= c || visited[y][x] <= node.t + 1 || board[y][x] == 'X' || board[y][x] == 'D') {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1));
                visited[y][x] = node.t + 1;
            }
        }
        
        return visited;
    }
    
    private static int bfs_beaver(int r, int c, char[][] board, int[][] water_history, int sy, int sx) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        
        queue.offer(new Node(sy, sx, 0));
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (board[node.y][node.x] == 'D') {
                return node.t;
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= r || x < 0 || x >= c
                        || !(water_history[y][x] > node.t + 1 || water_history[y][x] == Integer.MAX_VALUE)
                        || visited[y][x] == true || board[y][x] == 'X') {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.t + 1));
                visited[y][x] = true;
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    private static int calc(int r, int c, char[][] board, int sy, int sx) {
        int[][] water_history = bfs_water(r, c, board);
        return bfs_beaver(r, c, board, water_history, sy, sx);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[r][c];
        int sy = 0, sx = 0;
        
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'S') {
                    sy = i;
                    sx = j;
                }
            }
        }
        
        int result = calc(r, c, board, sy, sx);
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    }
}
