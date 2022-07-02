package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.WeakHashMap;

/*  Implement a public static method that takes two Strings for two filenames as parameters. The first
    file contains lines of words or integers, each word/integer is separated by a comma (except for the last
    one of a line). Read the first file, and write any prime numbers to the second file, separate by a line.
    Specifications
    • Package name: edu.sjsu.assignment2
    • Class name: MyFile
    • Method name: writePrimes
 */
public class MyFile {
    // read inputFile line by line
    // for each line
    // get each word(separated by a comma)
    // for each word, if it's a prime, write to outputFile
    public static void main(String[] args) throws FileNotFoundException {
        String file1 = "file1";
        String file2 =" ";
        writePrimes("file1" , "file2");
    }

    public static void writePrimes(String inputFile , String outputFile) throws FileNotFoundException {
        // read inputFile line by line
        File input = new File(inputFile);

        // Try-with-resource
        try (Scanner scanner = new Scanner(input);PrintWriter writer = new PrintWriter(outputFile)) {
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                Scanner lineScanner = new Scanner(current);
                lineScanner.useDelimiter(",");

                while (lineScanner.hasNextLine()) {
                    String word = lineScanner.next();
                    if (isPrime(word)) {
                        writer.println(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }
    }

    private static boolean isPrime(String input) {
        // parse string a number, check from 2 to sqrt of the number
        try {
            int n = Integer.parseInt(input);
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
