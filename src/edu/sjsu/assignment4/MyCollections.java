package edu.sjsu.assignment4;

import java.awt.event.WindowFocusListener;
import java.io.*;
import java.util.*;

// published at:https://liulingdu.github.io/edu/sjsu/assignment4/MyCollections.html

/**
 * MyCollection class
 */
public class MyCollections {
    /**
     * print a collection of files
     *
     * @param files collection of files.
     *              <br>*** indicates the end of the file content
     */
    public static void printFiles(Queue<File> files) throws IOException {
        while (!files.isEmpty()) {
            File current = files.poll();
            BufferedReader br = new BufferedReader(new FileReader(current));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("***");
        }
    }

    private static void print(File file) {

    }

    /**
     * remove every nth element of a collection of employee names
     *
     * @param employees employee list
     * @param n         the nth element to be removed
     */
    public static void downsize(LinkedList<String> employees , int n) {
        ListIterator<String> listIterator = employees.listIterator();
        int index = 0;

        while (listIterator.hasNext()) {
            listIterator.next();
            index++;
            if (index % n == 0) {
                listIterator.remove();
            }
        }
    }

    /**
     * check if a String has balanced parentheses
     *
     * @param exp the string to check
     *            <br>（For simplicity, suppose we only have ( ) and [ ]s）
     * @return whether it is a balanced string
     */

    public static boolean isBalanced(String exp) {
        Stack<Character> parentheses = new Stack<>();
        for (char c : exp.toCharArray()) {
            // if ( push )
            if (c == '(') parentheses.push(')');
                // else if [ push ]
            else if (c == '[') parentheses.push(']');
                // else if ) or ], check if the top of stack matches
                // if not, ( or the stack is empty ), return false;
                // if yes, pop the top
            else if (c == ')' || c == ']') {
                if(parentheses.isEmpty()) return false;
                char top = parentheses.peek();
                if (c == top) parentheses.pop();
                else {
                    if ((c != '(') || parentheses.empty()) return false;
                }
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        String exp=("[(3*5)]^2]");
        isBalanced(exp);
    }
}