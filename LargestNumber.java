import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder builder = new StringBuilder();
        for (String s : array) {
            builder.append(s);
        }
        var result = builder.toString();
        return result.startsWith("0") ? "0" : result;
    }
}
