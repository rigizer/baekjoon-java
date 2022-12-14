import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21736

public class BOJ21736 {
    static class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int bfs(int n, int m, char[][] board, int sy, int sx) {
        int result = 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        
        queue.offer(new Node(sy, sx));
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (board[node.y][node.x] == 'P') {
                result++;
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x] == true || board[y][x] == 'X') {
                    continue;
                }
                
                queue.offer(new Node(y, x));
                visited[y][x] = true;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char board[][] = new char[n][m];
        
        int sy = 0, sx = 0;
        
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }
        
        int result = bfs(n, m, board, sy, sx);
        System.out.println(result == 0 ? "TT" : result);
    }
}
