import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576

class Node {
    int y;
    int x;
    int date;
    
    Node(int y, int x, int date) {
        this.y = y;
        this.x = x;
        this.date = date;
    }
}

public class BOJ7576 {
    static int[] dy = {0, 1, 0, -1};   // y: 좌하우상
    static int[] dx = {-1, 0, 1, 0};   // x: 좌하우상
    
    private static int bfs(int[][] map, Queue<Node> queue) {
        int date = 0;
        
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
            date = node.date;
            map[node.y][node.x] = 1;  // visited
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= map.length || x < 0 || x >= map[0].length || map[y][x] != 0) {
                    continue;
                }
                
                queue.offer(new Node(y, x, node.date + 1));
                map[y][x] = 1;
            }
        }
        
        // 모두 익었는지 확인
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return date;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[height][width];
        Queue<Node> queue = new ArrayDeque<>();
        
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int date = bfs(map, queue);
        System.out.println(date);
    }
}
