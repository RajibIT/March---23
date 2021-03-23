
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumTriplet {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(21, 18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605))));
    }
    public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            arr.add(Integer.MIN_VALUE);
        }
        for(int i = 1; i < A.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(A.get(j) < A.get(i))
                    arr.set(i, Math.max(arr.get(i), A.get(i) + A.get(j)));
            }
        }
        ArrayList<Integer> finalArr = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            finalArr.add(Integer.MIN_VALUE);
        }
        for(int i = 2; i < A.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(A.get(j) < A.get(i) && arr.get(j) != Integer.MIN_VALUE)
                    finalArr.set(i, Math.max(finalArr.get(i), A.get(i) + arr.get(j)));
            }
        }
        return finalArr.get(finalArr.size() - 1);
    }
}
