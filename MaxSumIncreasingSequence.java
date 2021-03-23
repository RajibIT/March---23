import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSequence {
    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30}));
    }
	
	
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] maxSum = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            maxSum[i] = array[i];
        }
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, -1);

        for(int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            for(int j = 0; j < i; j++) {
                if(array[j] < currentValue) {
                    int newMaxValue = currentValue + array[j];
                    if(newMaxValue > maxSum[i]) {
                        maxSum[i] += array[j];
                        sequences[i] = j;
                    }
                }
            }
        }
        int idx = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < maxSum.length; i++) {
            if(maxSum[i] > maxValue) {
                maxValue = maxSum[i];
                idx = i;
            }
        }
        return buildSequences(sequences, array, idx);
    }
    public static List<List<Integer>> buildSequences(int[] sequences,int[] array, int idx) {
        List<List<Integer>> maxSumIncreasingSequence = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int i = array.length - 1;
        boolean flag = false;
        while(idx > 0 && sequences[idx] != -1) {
            temp.add(0, array[idx]);
            idx = sequences[idx];
        }
        temp.add(0, array[idx]);
        int maxSum = 0;
        for(int value : temp) {
            maxSum = maxSum + value;
        }
        maxSumIncreasingSequence.add(Arrays.asList(maxSum));
        maxSumIncreasingSequence.add(temp);
        return maxSumIncreasingSequence;
    }
}
