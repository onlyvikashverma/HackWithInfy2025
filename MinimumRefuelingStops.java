import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumRefuelingStops {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int fuel = sc.nextInt();
        int n = sc.nextInt();
        int[][] stations = new int[n][2];
        for (int i = 0; i < n; i++) {
            stations[i][0] = sc.nextInt();
            stations[i][1] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0, stops = 0;

        while (fuel < target) {
            while (idx < n && stations[idx][0] <= fuel) {
                pq.offer(stations[idx][1]);
                idx++;
            }
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            fuel += pq.poll();
            stops++;
        }
        System.out.println(stops);
    }
    
}
