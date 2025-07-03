import java.util.Arrays;

public class ArrayPartition {
  public int arrayPairSum(int[] nums) {
    int ans = 0;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i += 2)
      ans += nums[i];

    return ans;
  }
  public static void main(String[] args) {
    ArrayPartition ap = new ArrayPartition();
    int[] nums = {1, 4, 3, 2};
    System.out.println(ap.arrayPairSum(nums)); 
  }
}
