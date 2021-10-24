package test;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    private static boolean[][] isVisited;
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};
    //동, 남, 서, 북
    private static int answer = Integer.MAX_VALUE;

    private static void bfs(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));//처음은 0으로 초기화
        while (!queue.isEmpty()) {//큐에는 끝까지 이동했을때의 거리가 담김
            Point point = queue.poll();
            if (point.r== maps.length-1 && point.c == maps[0].length-1) { //도착지점(5열, 5행)
                answer = Math.min(answer, point.cnt+1);//두개의 수를 비교하여 작은것 리턴 포인트는 칸의 개수
                return;
            }
            for (int i = 0; i < 4; i++) {//동서남북을 반복하면서 벽이 없는 자리이면서 끝자리가 이동
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (r2 >= 0 && r2 < maps.length && c2 >= 0 && c2 < maps[0].length && maps[r2][c2] == 1 && !isVisited[r2][c2]) {//1은 벽이없는 자리
                    //벽이 없는 자리 이면서 방문하지 않았고 맵의가로와 세로가 최대 행렬범위 이하일때
                    queue.add(new Point(r2, c2, point.cnt + 1));
                    isVisited[r2][c2] = true;//이동했다는 표시
                }
            }
        }
    }

    public int solution(int[][] maps) { // 0:벽, 1:길
        isVisited = new boolean[maps.length][maps[0].length];//5, 5
        bfs(maps);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    private static class Point {
        int r;
        int c;
        int cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}