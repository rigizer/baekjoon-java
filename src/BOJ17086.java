import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17086

class Node {
    int y;
    int x;
    int weight;
    
    Node(int y, int x, int weight) {
        this.y = y;
        this.x = x;
        this.weight = weight;
    }
}

public class BOJ17086 {
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};   // y: 북, 북동, 동, 남동, 남, 남서, 서, 북서 (시계방향, 12시 기준)
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};   // x: 북, 북동, 동, 남동, 남, 남서, 서, 북서 (시계방향, 12시 기준)
    
    private static int bfs(int[][] map, Queue<Node> queue) {
        int weight = 0;
        
        // 초기 시작지점 탐색
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        
        // BFS
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            weight = node.weight;
            map[node.y][node.x] = 1;
            
            for (int d = 0; d < 8; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= map.length || x < 0 || x >= map[0].length || map[y][x] != 0) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.weight + 1));
                map[y][x] = 1;
            }
        }
        
        return weight;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[height][width];
        Queue<Node> queue = new ArrayDeque<>();
        
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int weight = bfs(map, queue);
        System.out.println(weight);
    }
}
