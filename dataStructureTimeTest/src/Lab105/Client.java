package Lab105;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Brandon Neri
 * @version 02/20/2021
 *
 * Client.java is a java class that preforms a series of timing tests for 
 * the ArrayStack, LinkedStack, ArrayQueue, LinkedQueue, and ArrayList 
 * data structures. Each test measures how long it takes to add and remove 
 * n amount of Integers from the structure. This is measured in nanoseconds 
 * and is printed to the console in an ASCII table. Sample sizes of n can 
 * range from 10 to 1,000,000,000.
 *
 */
public class Client {

    public static void main(String[] args) {

        // Lists to store timing results
        ArrayList<Long> asTime = new ArrayList<>();
        ArrayList<Long> lsTime = new ArrayList<>();
        ArrayList<Long> aqTime = new ArrayList<>();
        ArrayList<Long> lqTime = new ArrayList<>();
        ArrayList<Long> alTime = new ArrayList<>();
        ArrayList<Long> nSizes = new ArrayList<>();

        // Chosen test size
        long testSize = 10000000;
        int n = 0;

        // ArrayStack Test Run
        for (int i = 10; i < testSize; i = i * 10) {
            // Create Instance of ArrayStack
            ArrayStack<Integer> as = new ArrayStack<>(i);

            // Run Test
            long startTimer = System.nanoTime(); // Timer Start
            for (int j = 0; j < i; j++) {
                as.push(1);
            }
            for (int j = 0; j < i; j++) {
                as.pop();
            }
            long stopTimer = System.nanoTime(); // Timer Stop

            // Record elapsed time
            long time = stopTimer - startTimer;
            asTime.add(n, time);
            n++;
        }
        n = 0;

        // LinkedStack Test Run
        for (int i = 10; i < testSize; i = i * 10) {
            // Create Instance of LinkedStack
            LinkedStack<Integer> ls = new LinkedStack<>();

            // Run Test
            long startTimer = System.nanoTime(); // Timer Start
            for (int j = 0; j < i; j++) {
                ls.push(1);
            }
            for (int j = 0; j < i; j++) {
                ls.pop();
            }
            long stopTimer = System.nanoTime(); // Timer Stop

            // Record elapsed time
            long time = stopTimer - startTimer;
            lsTime.add(n, time);
            n++;
        }
        n = 0;

        // ArrayQueue Test Run
        for (int i = 10; i < testSize; i = i * 10) {
            // Create Instance of ArrayQueue
            ArrayQueue<Integer> aq = new ArrayQueue<>(i);

            // Run Test
            long startTimer = System.nanoTime(); // Timer Start
            for (int j = 0; j < i; j++) {
                aq.enqueue(1);
            }
            for (int j = 0; j < i; j++) {
                aq.dequeue();
            }
            long stopTimer = System.nanoTime(); // Timer Stop

            // Record elapsed time
            long time = stopTimer - startTimer;
            aqTime.add(n, time);
            n++;
        }
        n = 0;

        // LinkedQueue Test Run
        for (int i = 10; i < testSize; i = i * 10) {
            // Create Instance of LinkedQueue
            LinkedQueue<Integer> lq = new LinkedQueue<>();

            // Run Test
            long startTimer = System.nanoTime(); // Timer Start
            for (int j = 0; j < i; j++) {
                lq.enqueue(1);
            }
            for (int j = 0; j < i; j++) {
                lq.dequeue();
            }
            long stopTimer = System.nanoTime(); // Timer Stop

            // Record elapsed time
            long time = stopTimer - startTimer;
            lqTime.add(n, time);
            n++;
        }
        n = 0;

        // ArrayList Test Run
        for (int i = 10; i < testSize; i = i * 10) {
            // Create Instance of ArrayList
            ArrayList<Integer> al = new ArrayList<>(i);
            int count = 0;

            // Run Test
            long startTime = System.nanoTime(); // Timer Start
            for (int j = 0; j < i; j++) {
                al.add(count, i);
                count++;
            }
            for (int j = 0; j < i; j++) {
                al.set(al.size() - 1, null);
                count--;
            }
            long stopTime = System.nanoTime(); // Timer Stop

            // Record elapsed time
            long time = stopTime - startTime;
            alTime.add(n, time);
            n++;
        }
        n = 0;

        // Store each n sample size tested 
        for (int i = 10; i < testSize; i = i * 10) {
            nSizes.add(n, (long) i);
            n++;
        }

        // Formatted arrays to store timing results
        String[] asTimeFormatted = formatValues(asTime);
        String[] lsTimeFormatted = formatValues(lsTime);
        String[] aqTimeFormatted = formatValues(aqTime);
        String[] lqTimeFormatted = formatValues(lqTime);
        String[] alTimeFormatted = formatValues(alTime);
        String[] nSizesFormatted = formatValues(nSizes);

        // Check for the maximum spaces needed for the table
        int asSize = findMaxCharSize(asTimeFormatted);
        int lsSize = findMaxCharSize(lsTimeFormatted);
        int aqSize = findMaxCharSize(aqTimeFormatted);
        int lqSize = findMaxCharSize(lqTimeFormatted);
        int alSize = findMaxCharSize(alTimeFormatted);
        String bar = createBar(alSize + lqSize + aqSize + lsSize + asSize + 42);

        // Header
        System.out.println("ASCII Time Test Table " + "(Run Size: " + testSize + ")");
        System.out.println(bar);
        System.out.printf("|  %11s  |  %" + asSize
                + "s  |  %" + lsSize
                + "s  |  %" + aqSize
                + "s  |  %" + lqSize
                + "s  |  %" + alSize
                + "s  |", "N", "AStack", "LStack", "AQueue", "LQueue", "AList");
        System.out.println("\n" + bar);

        // Formatted ASCII Output Line
        for (int i = 0; i < nSizesFormatted.length; i++) {
            System.out.printf("|  %11s  |  %" + asSize + "s  |  %" + lsSize
                    + "s  |  %" + aqSize
                    + "s  |  %" + lqSize
                    + "s  |  %" + alSize
                    + "s  |", nSizesFormatted[i], asTimeFormatted[i], lsTimeFormatted[i],
                    aqTimeFormatted[i], lqTimeFormatted[i], alTimeFormatted[i]);
            System.out.println("\n" + bar);
        }
    }

    /**
     *
     * @param array a given array of type String
     * @return an int of the size of the largest element in the array
     */
    private static int findMaxCharSize(String[] array) {
        int max = 0;
        for (String item : array) {
            if (max < item.length()) {
                max = item.length();
            }
        }
        return max;
    }

    /**
     *
     * @param length int of a bar length for an ASCII table
     * @return a string of the printed ASCII bar of a given length
     */
    private static String createBar(int length) {
        String bar = "";
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                bar += "+";
            } else {
                bar += "-";
            }
        }
        return bar;
    }

    /**
     *
     * @param array an ArrayList of type long
     * @return a String Array that places commas at correct numeric locations
     */
    private static String[] formatValues(ArrayList<Long> array) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String[] newArray = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            newArray[i] = nf.format(array.get(i));
        }
        return newArray;
    }
}
