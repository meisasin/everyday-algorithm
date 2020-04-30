import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 * @date 2020/4/29 Í 1:16 下午
 */
public class Fib {

    public static Map<Integer, Long> nMap = new HashMap<>();

    public static void main(String[] args) {
        // 1 1 2 3 5 8
        LocalDateTime start = LocalDateTime.now();
        System.out.println(fib_ori(30));
        System.out.println("Time is " + start + " - " + LocalDateTime.now());

        start = LocalDateTime.now();
        System.out.println(fib(30));
        System.out.println("Time is " + start + " - " + LocalDateTime.now());

        start = LocalDateTime.now();
        System.out.println(fib_arr(30));
        System.out.println("Time is " + start + " - " + LocalDateTime.now());
    }

    public static long fib_ori(int n) {
        System.out.println(" n = " + n);
        if (n == 1 || n == 2)
            return 1;
        return fib_ori(n - 1) + fib_ori(n - 2);
    }
    public static long fib(int n) {
        Long num = nMap.get(n);
        if (num != null) {
            return num;
        }
        System.out.println(" n = " + n);
        if (n == 1 || n == 2)
            return 1;
        long i = fib(n - 1) + fib(n - 2);
        nMap.put(n, i);
        return i;
    }


    public static long fib_arr(int n) {
        long[] nArr = new long[n];
        nArr[0] = 1;
        nArr[1] = 1;
        for (int i = 2 ; i < n ; i ++) {
            nArr[i] = nArr[i - 1] + nArr[i - 2];
        }
        return nArr[n - 1];
    }
}
