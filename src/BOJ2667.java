import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

// https://www.acmicpc.net/problem/2667

class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ2667 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    
    private static int bfs(char[][] map, boolean[][] visited, int n, int yy, int xx) {
        int count = 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(yy, xx));
        visited[yy][xx] = true;
        count++;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int y = node.y + dy[d];
                int x = node.x + dx[d];
                
                if (y < 0 || y >= n || x < 0 || x >= n || map[y][x] == '0' || visited[y][x] == true) {
                    continue;
                }
                
                queue.offer(new Node(y, x));
                visited[y][x] = true;
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && visited[i][j] == false) {
                    int count = bfs(map, visited, n, i, j);
                    list.add(count);
                }
            }
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        list.stream().forEach(i -> System.out.println(i));
    }
}
