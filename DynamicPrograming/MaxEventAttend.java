package HackWithInfy2025.DynamicPrograming;
import java.util.*;

public class MaxEventAttend {
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, n = events.length, res = 0;

        // Find max end day
        int maxDay = Arrays.stream(events).mapToInt(e -> e[1]).max().orElse(0);

        for (int day = 1; day <= maxDay; day++) {
            // Add events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event (the one that ends earliest)
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt(); // start
            events[i][1] = sc.nextInt(); // end
        }
        System.out.println("Max events that can be attended: " + maxEvents(events));
    }
}