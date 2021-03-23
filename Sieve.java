
import java.util.ArrayList;

public class Sieve {
    public static void main(String[] args) {
        System.out.println(sieve(10));
    }
    public static ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for(int i = 2; i <= A; i++) {
            result.add(1);
        }
        int k = 0;
        for(int i = 2; i <= Math.sqrt(A); i++) {
            for(int j = i; i * j <= A - k; j++) {
                result.remove(i * j);
                k++;
            }
        }
        return result;
    }
}
