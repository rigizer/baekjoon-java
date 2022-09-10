import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2206

class Node {
    int y;
    int x;
    int d;  // 총 이동 거리
    int k;  // 벽을 뚫을 수 있는 횟수
    
    public Node(int y, int x, int d, int k) {
        this.y = y;
        this.x = x;
        this.d = d;
        this.k = k;
    }
}

public class BOJ2206 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int bfs(char map[][], boolean[][][] visited, int n, int m, int k) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1, k));
        visited[0][0][k] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == n - 1 && node.x == m - 1) {   // 목적지에 도달하면 탐색 종료
                return node.d;
            }
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x][node.k] == true) {
                    continue;
                }
                
                if (map[y][x] == '1' && node.k > 0) {   // 벽을 뚫을 수 있는 조건 추가
                    queue.offer(new Node(y, x, node.d + 1, node.k - 1));
                    visited[y][x][node.k - 1] = true;
                } else if (map[y][x] == '0') {                                // 일반 경로 탐색
                    queue.offer(new Node(y, x, node.d + 1, node.k));
                    visited[y][x][node.k] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = 1;
        
        char[][] map = new char[n][m];
        boolean visited[][][] = new boolean[n][m][k + 1];   // 벽을 뚫은 횟수에 대한 visited를 3차원 배열을 통해 경우의 수를 나눔
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        System.out.println(bfs(map, visited, n, m, k));
    }
}
