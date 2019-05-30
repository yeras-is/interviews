package defult;

import java.util.Arrays;

public class Fibonacci {

  public static long FibRecursion(int n) {
    if (n <= 1)
      return n;
    return FibRecursion(n - 1) + FibRecursion(n - 2);
  }

  public static long FibRecursionMemoisation(int n, long[] mem) {
    if (mem[n] != -1)
      return mem[n];

    if (n <= 1)
      return n;

    long result = FibRecursionMemoisation(n - 1, mem) + FibRecursionMemoisation(n - 2, mem);
    mem[n] = result;

    return result;
  }

  public static long FibEffective(int n) {
    long[] arr = new long[n + 1];

    arr[0] = 0;
    arr[1] = 1;

    for (int i = 2; i <= n; i++)
      arr[i] = arr[i - 1] + arr[i - 2];

    return arr[n];
  }

  public static void main(String[] args) {

    int n=30;

    long start = System.currentTimeMillis();
    System.out.print(FibRecursion(n));
    long finish = System.currentTimeMillis();
    System.out.println(", FibRecursion  time: " + (finish - start));

    start = System.currentTimeMillis();
    System.out.print(FibEffective(n));
    finish = System.currentTimeMillis();
    System.out.println(", FibEffective  time: " + (finish - start));


    long[] mem = new long[n+1];
    Arrays.fill(mem,-1);

    start = System.currentTimeMillis();
    System.out.print(FibRecursionMemoisation(n,mem));
    finish = System.currentTimeMillis();
    System.out.println(", FibRecursionMemoisation time: " + (finish - start));

  }
}
