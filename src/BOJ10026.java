import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedReader;

// https://www.acmicpc.net/problem/10026

public class BOJ10026 {
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
    
    private static void bfs(char[][] map, boolean[][] visited, int n, int i, int j, boolean isCw) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= n || visited[y][x] == true) {
                    continue;
                }
                
                if (isCw == true) {
                    if (((map[i][j] == 'R' || map[i][j] == 'G') && (map[y][x] == 'R' || map[y][x] == 'G')) || (map[i][j] == 'B' && map[y][x] == 'B')) {
                        queue.offer(new Node(y, x));
                        visited[y][x] = true;
                    }
                } else {
                    if (map[y][x] == map[i][j]) {
                        queue.offer(new Node(y, x));
                        visited[y][x] = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        char[][] map = new char[n][n];
        boolean[][] nonCwVisited = new boolean[n][n];
        boolean[][] cwVisited = new boolean[n][n];
                
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int nonCw = 0;
        int cw = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nonCwVisited[i][j] == false) {
                    nonCw++;
                    bfs(map, nonCwVisited, n, i, j, false);
                }
                
                if (cwVisited[i][j] == false) {
                    cw++;
                    bfs(map, cwVisited, n, i, j, true);
                }
            }
        }
        
        System.out.println(String.format("%d %d", nonCw, cw));
    }
}
