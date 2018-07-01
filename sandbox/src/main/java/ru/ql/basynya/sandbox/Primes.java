package ru.ql.basynya.sandbox;

public class Primes {

  public static boolean isPrime(int n) {
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < Math.sqrt(n) && n % i == 0) {
      i++;
    }
    return i == n;
  }

  public static boolean isPrime(long n) {
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
