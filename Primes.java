package q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * Primes: prints out the prime numbers within a range.
 * </p>
 * 
 * 
 * @author Amber (Ying-Ju) Chen
 * @version 1.0
 */
public class Primes {
    /**
     * A boolean list called primes.
     */
    private ArrayList<Boolean> primes;
    /**
     * An integer used to initialize the primes array to have maximum index N.
     */
    private int limit;

    /**
     * 
     * Constructs an object of type Primes.
     * 
     * @param n
     *            An integer used to initialize the primes array to have maximum
     *            index N.
     * @throw IllegalArgumentException error when input is smaller than 0.
     */
    public Primes(int n) {
        primes = new ArrayList<Boolean>();
        this.limit = n;
        if (n <= 0) {
            throw new IllegalArgumentException("Input " 
        + "needs to be bigger than 0.");
        }
    }

    /**
     * This uses the Sieve of Eratosthenes to determine which indices are prime
     * (true) and which are not (false).
     */
    private void calculatePrimes() {
        for (int i = 0; i <= limit; i++) {
            boolean check = true;

            for (int x = 2; x < i; x++) {
                if (i % x == 0) {
                    check = false;
                    break;
                }
            }
            if (check && i != 0 && i != 1) {
                primes.add(true);
            }
            if (!check || i == 0 || i == 1) {
                primes.add(false);
            }
        }
    }

    /**
     * prints out the list of primes you calculated.
     */
    public void printPrimes() {
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i)) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Returns an int representing the number of primes in the range [0, n].
     * 
     * @return the number of primes within range
     */
    public int countPrimes() {
        int count = 0;
        for (Boolean prime : primes) {
            if (prime) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns true if x is prime and false if it is not.
     * 
     * @param x
     *            number being checked
     * @return true or false
     */
    public boolean isPrime(int x) {
        return primes.get(x);
    }

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an upper bound:");
        int upperBound = scan.nextInt();
        Primes primeList = new Primes(upperBound);
        primeList.calculatePrimes();
        System.out.println("There are " + primeList.countPrimes() + " primes:");
        System.out.println("The prime numbers between 0 and " 
        + upperBound + " are:");
        primeList.printPrimes();
        scan.close();
    }

};
