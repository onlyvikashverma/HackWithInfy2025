import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value;
        int weight;

        Item(int v, int w) {
            value = v;
            weight = w;
        }
        double getRatio() {
            return (double) value / weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.getRatio(), a.getRatio()));

        double totalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (w >= items[i].weight) {
                totalValue += items[i].value;
                w -= items[i].weight;
            } else{
                totalValue += items[i].getRatio() * w;
                break; 
            }
        }
        System.out.printf("%.2f\n", totalValue);

        sc.close();
    }
}
