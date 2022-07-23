package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyCollectionsTest {

    @Test
    void printFiles() throws IOException {
        Queue<File> files = new PriorityQueue<>();
        File file1 = new File("/Users/amber_du/Desktop/SJSU/CS49J/Main/src/edu/sjsu/assignment4/file1");
        File file2 = new File("/Users/amber_du/Desktop/SJSU/CS49J/Main/src/edu/sjsu/assignment4/file2");
        files.offer(file1);
        files.offer(file2);
        String result = new String("Hello, welcome to class!\n" +
                "***\n" +
                "Assignment 4 is posted.\n" +
                "Please submit it before due date.\n" +
                "***");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));
        MyCollections.printFiles(files);
        assertEquals(result , outputStream.toString().trim());
    }

    @Test
    void downsize() {
        String[] list = {"Tom" , "Bob" , "Cathy" , "Alice" , "Trudy" , "Harry" , "Denny"};
        LinkedList<String> employees = new LinkedList<>(Arrays.asList(list));
        MyCollections.downsize(employees , 3);
        String[] expected = {"Tom" , "Bob" , "Alice" , "Trudy" , "Denny"};
        LinkedList<String> expectedOutput = new LinkedList<>(Arrays.asList(expected));
        System.out.println(employees);
        assertEquals(expectedOutput , employees);
    }

    @Test
    void isBalanced() {
        // should return true
        assertEquals(true , MyCollections.isBalanced("System.out.println(list.get(0))"));
        // should return true
        assertEquals(true , MyCollections.isBalanced("[](3*5)^2"));
        // should return false
        assertEquals(false , MyCollections.isBalanced("[(2+3]*5)^2"));
        // should return false
        assertEquals(false , MyCollections.isBalanced("System.out.println(list.get(0)"));
        // should return false
        assertEquals(false , MyCollections.isBalanced("[(3*5)]^2]"));
    }
}