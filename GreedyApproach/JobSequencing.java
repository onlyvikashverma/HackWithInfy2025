import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {
     static class Job {
        String id;
        int deadline, profit;

        Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            jobs[i] = new Job(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slot = new boolean[maxDeadline + 1];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println(totalProfit);
        sc.close();
    }
}
