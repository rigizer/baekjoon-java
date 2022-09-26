import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17836

public class BOJ17836 {
	static class Node {
		int y;
		int x;
		int t;
		boolean isGram;
		
		public Node(int y, int x, int t, boolean isGram) {
			this.y = y;
			this.x = x;
			this.t = t;
			this.isGram = isGram;
		}
	}
	
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	
	private static int bfs(int[][] map, int[][][] visited, int n, int m, int t) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0, false));
		visited[0][0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.y == n - 1 && node.x == m - 1) {
				return node.t;
			}
			
			if (node.t >= t) {
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int y = node.y + dy[d];
				int x = node.x + dx[d];
				
				if (y < 0 || y >= n || x < 0 || x >= m) {
					continue;
				}
				
				if (!node.isGram && visited[0][y][x] == 1) continue;
				if (node.isGram && visited[1][y][x] == 1) continue;
				
				if (!node.isGram && map[y][x] == 1) {
					continue;
				}
				
				if (map[y][x] == 2 || node.isGram) {
					queue.offer(new Node(y, x, node.t + 1, true));
					visited[1][y][x] = 1;
				} else {
					queue.offer(new Node(y, x, node.t + 1, false));
					visited[0][y][x] = 1;
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
		int t = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][][] visited = new int[2][n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = bfs(map, visited, n, m, t);
		
		if (result == -1) {
			System.out.println("Fail");
		} else {
			System.out.println(result);
		}
	}
}
