import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17114

class Node {
    int[] point = new int[11];
    int date;
    
    public Node(int[] point, int date) {
        this.point = point;
        this.date = date;
    }
}

public class BOJ17114 {
    static int[] _dw = {-1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _dv = {0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _du = {0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _dt = {0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _ds = {0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _dr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _dq = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] _dp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0};
    static int[] _do = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0};
    static int[] _dn = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0};
    static int[] _dm = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1};
    
    private static int bfs(int[] data, int[][][][][][][][][][][] map, Queue<Node> queue) {
        int date = 0;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            date = node.date;
            map[node.point[0]][node.point[1]][node.point[2]][node.point[3]][node.point[4]][node.point[5]][node.point[6]][node.point[7]][node.point[8]][node.point[9]][node.point[10]] = 1;
            
            for (int d = 0; d < 22; d++) {
                int w = node.point[0] + _dw[d];
                int v = node.point[1] + _dv[d];
                int u = node.point[2] + _du[d];
                int t = node.point[3] + _dt[d];
                int s = node.point[4] + _ds[d];
                int r = node.point[5] + _dr[d];
                int q = node.point[6] + _dq[d];
                int p = node.point[7] + _dp[d];
                int o = node.point[8] + _do[d];
                int n = node.point[9] + _dn[d];
                int m = node.point[10] + _dm[d];
                
                if (w < 0 || w >= data[10]
                    || v < 0 || v >= data[9]
                    || u < 0 || u >= data[8]
                    || t < 0 || t >= data[7]
                    || s < 0 || s >= data[6]
                    || r < 0 || r >= data[5]
                    || q < 0 || q >= data[4]
                    || p < 0 || p >= data[3]
                    || o < 0 || o >= data[2]
                    || n < 0 || n >= data[1]
                    || m < 0 || m >= data[0]
                    || map[w][v][u][t][s][r][q][p][o][n][m] != 0) {
                    continue;
                }
                
                queue.offer(new Node(new int[] {w, v, u, t, s, r, q, p, o, n, m}, node.date + 1));
                map[w][v][u][t][s][r][q][p][o][n][m] = 1;
            }
        }
            
        for (int w = 0; w < data[10]; w++) {
            for (int v = 0; v < data[9]; v++) {
                for (int u = 0; u < data[8]; u++) {
                    for (int t = 0; t < data[7]; t++) {
                        for (int s = 0; s < data[6]; s++) {
                            for (int r = 0; r < data[5]; r++) {
                                for (int q = 0; q < data[4]; q++) {
                                    for (int p = 0; p < data[3]; p++) {
                                        for (int o = 0; o < data[2]; o++) {
                                            for (int n = 0; n < data[1]; n++) {
                                                for (int m = 0; m < data[0]; m++) {
                                                    if (map[w][v][u][t][s][r][q][p][o][n][m] == 0) {
                                                        return -1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return date;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[] data = new int[11];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 11; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][][][][][][][][][][] map = new int[data[10]][data[9]][data[8]][data[7]][data[6]][data[5]][data[4]][data[3]][data[2]][data[1]][data[0]];
        Queue<Node> queue = new ArrayDeque<>();
        
        for (int w = 0; w < data[10]; w++) {
            for (int v = 0; v < data[9]; v++) {
                for (int u = 0; u < data[8]; u++) {
                    for (int t = 0; t < data[7]; t++) {
                        for (int s = 0; s < data[6]; s++) {
                            for (int r = 0; r < data[5]; r++) {
                                for (int q = 0; q < data[4]; q++) {
                                    for (int p = 0; p < data[3]; p++) {
                                        for (int o = 0; o < data[2]; o++) {
                                            for (int n = 0; n < data[1]; n++) {
                                                st = new StringTokenizer(br.readLine());
                                                for (int m = 0; m < data[0]; m++) {
                                                    int d = Integer.parseInt(st.nextToken());
                                                    map[w][v][u][t][s][r][q][p][o][n][m] = d;
                                                    if (d == 1) {
                                                        queue.offer(new Node(new int[] {w, v, u, t, s, r, q, p, o, n, m}, 0));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int date = bfs(data, map, queue);
        System.out.println(date);
    }
}
