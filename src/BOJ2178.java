import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178

class Node {
    int y;
    int x;
    int weight;
    
    public Node(int y, int x, int weight) {
        this.y = y;
        this.x = x;
        this.weight = weight;
    }
}

public class BOJ2178 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static int bfs(int n, int m, char map[][], boolean[][] visited) {
        int result = 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == n - 1 && node.x == m - 1) {
                return node.weight;
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= m || map[y][x] == '0' || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.weight + 1));
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
        
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        
        System.out.println(bfs(n, m, map, visited));
    }
}
