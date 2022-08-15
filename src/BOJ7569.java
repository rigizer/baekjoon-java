import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569

class Node {
    int z;
    int y;
    int x;
    int date;
    
    Node(int z, int y, int x, int date) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node [z=" + z + ", y=" + y + ", x=" + x + ", date=" + date + "]";
    }
}

public class BOJ7569 {
    static int[] dz = {-1, 1, 0, 0, 0, 0};   // z: 상, 하, 좌, 우, 앞, 뒤
    static int[] dy = {0, 0, 0, 0, -1, 1};   // y: 상, 하, 좌, 우, 앞, 뒤
    static int[] dx = {0, 0, -1, 1, 0, 0};   // x: 상, 하, 좌, 우, 앞, 뒤
    
    private static int bfs(int[][][] map, Queue<Node> queue) {
        int date = 0;
        
        // 초기 시작지점 탐색
        for (int z = 0; z < map.length; z++) {
            for (int y = 0; y < map[0].length; y++) {
                for (int x = 0; x < map[0][0].length; x++) {
                    if (map[z][y][x] == 1) {
                        queue.offer(new Node(z, y, x, 0));
                    }
                }
            }
        }
        
        // BFS
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            date = node.date;
            map[node.z][node.y][node.x] = 1;
            
            for (int d = 0; d < 6; d++) {
                int z = node.z + dz[d];
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (z < 0 || z >= map.length
                    || y < 0 || y >= map[0].length
                    || x < 0 || x >= map[0][0].length
                    || map[z][y][x] != 0) {
                    continue;
                }
                
                queue.offer(new Node(z, y, x, node.date + 1));
                map[z][y][x] = 1;
            }
        }
        
        // 모두 익었는지 확인
        for (int z = 0; z < map.length; z++) {
            for (int y = 0; y < map[0].length; y++) {
                for (int x = 0; x < map[0][0].length; x++) {
                    if (map[z][y][x] == 0) {
                        return -1;
                    }
                }
            }
        }
        
        return date;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x_max = Integer.parseInt(st.nextToken());
        int y_max = Integer.parseInt(st.nextToken());
        int z_max = Integer.parseInt(st.nextToken());
        
        int[][][] map = new int[z_max][y_max][x_max];
        Queue<Node> queue = new ArrayDeque<>();
        
        for (int z = 0; z < z_max; z++) {
            for (int y = 0; y < y_max; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < x_max; x++) {
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        int date = bfs(map, queue);
        System.out.println(date);
    }
}
