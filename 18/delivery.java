package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class delivery {
    public static void main(String args[]){
        int road [][] = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 5;
        int K = 3;
        delivery(N,road,K);
        //n개 마을중 k시간 내로 배달할수있는 개수 리턴
    }

    public static int delivery(int N, int[][] road, int K) {
        final int MAX = 1000000;
        int answer = 0;

        int[][] adj = new int[N][N];//5 5 길이 이어져있는것
        for (var a : adj) {
            Arrays.fill(a, MAX);//1000000 값으로 초기화
        }
        //System.out.println(adj[0][1]);

        for (var a : road) {
            //2차원 배열에서 for each의 a는 1행 그것의 요소를 가져오면 행의 열로 가져와짐
            int x = a[0]-1;
            int y = a[1]-1;
            int w = a[2];
            if (w < adj[x][y]) {
                adj[x][y] = adj[y][x] = w;//xy 요소와 yx요소를 w로 초기화
            }
        }

        boolean[] visited = new boolean[N];//방문한곳 표시
        int[] dist = new int[N];//마을을 배달하는데 걸리는 시간
        System.out.println("0 : "+dist[0]);
        System.out.println("1 : "+dist[1]);
        System.out.println("2 : "+dist[2]);
        System.out.println("3 : "+dist[3]);
        System.out.println("4 : "+dist[4]);
        Arrays.fill(dist, MAX);//max값으로 초기화 5개원소 모두
        System.out.println("0 : "+dist[0]);
        System.out.println("1 : "+dist[1]);
        System.out.println("2 : "+dist[2]);
        System.out.println("3 : "+dist[3]);
        System.out.println("4 : "+dist[4]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {//fifo
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(dist[o1], dist[o2]);
            }
        });

        dist[0] = 0;
        pq.add(0);
        System.out.println("pq : "+pq);
        while(!pq.isEmpty()) {
            int curr = pq.poll(); //가장 아래 있는것
            System.out.println(curr);
            if (visited[curr]) continue;
            //방문했던 지점이면 다음 으로 넘김
            visited[curr] = true; //방문표시
            for (int i = 0; i < N; i++) {//n=5
                if (adj[curr][i] == MAX) continue;

                //현재위치에서 더 짧은 구간을 구한다.
                if (dist[i] > dist[curr] + adj[curr][i]) {
                    dist[i] = dist[curr] + adj[curr][i];
                    pq.offer(i);
                }
            }
        }

        //방문한 경로의 시간중 k시간 이하인곳만
        for (var a : dist) {
            if (a <= K) answer++;
        }

        return answer;
    }
}
