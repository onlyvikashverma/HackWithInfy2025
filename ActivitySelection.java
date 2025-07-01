import java.util.*;

public class ActivitySelection {
    static class Activity {
        int start, end;

        Activity(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[i] = new Activity(start, end);
        }
        Arrays.sort(arr, (a, b) -> a.end - b.end);
        int count = 1;
        int lastEnd = arr[0].end;
        for (int i = 1; i < n; i++) {
            if (arr[i].start >= lastEnd) {
                count++;
                lastEnd = arr[i].end; 
            }
        }
        System.out.println(count);
    }
}
