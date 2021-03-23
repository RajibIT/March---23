import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs {
    public static void main(String[] args) {
        System.out.println(sameBsts(new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11)), new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81))));
    }
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if(arrayOne.size() == 0 || arrayTwo.size() == 0)
			return true;
		if(arrayOne.get(0) != arrayTwo.get(0) || arrayOne.size() != arrayTwo.size())
			return false;
		List<Integer> arrayOneSmallerThanRoot = new ArrayList<Integer>();
		List<Integer> arrayOneBiggerThanRoot = new ArrayList<Integer>();
		List<Integer> arrayTwoSmallerThanRoot = new ArrayList<Integer>();
		List<Integer> arrayTwoBiggerThanRoot = new ArrayList<Integer>();
		int firstElement = arrayOne.get(0);
		for(int i = 1; i < arrayOne.size(); i++) {
			if(firstElement > arrayOne.get(i)) {
				arrayOneSmallerThanRoot.add(arrayOne.get(i));
			}else if(firstElement <= arrayOne.get(i)){
				arrayOneBiggerThanRoot.add(arrayOne.get(i));
			}
			if(firstElement > arrayTwo.get(i)) {
				arrayTwoSmallerThanRoot.add(arrayTwo.get(i));
			}else if(firstElement <= arrayTwo.get(i)) {
				arrayTwoBiggerThanRoot.add(arrayTwo.get(i));
			}
		}

    return sameBsts(arrayOneSmallerThanRoot, arrayTwoSmallerThanRoot) && sameBsts(arrayOneBiggerThanRoot, arrayTwoBiggerThanRoot);

    }
}
