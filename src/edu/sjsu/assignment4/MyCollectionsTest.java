package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyCollectionsTest {

    /*@Test
    void printFiles() {
        File file1 = new File("/Users/amber_du/Desktop/SJSU/CS49J/Main/file1");
        File file2 = new File("/Users/amber_du/Desktop/SJSU/CS49J/Main/file2");
        Queue<File> files=[file1,file2];
        String result = new String("Hello, welcome to class!\n" +
                "***\n" +
                "Assignment 4 is posted.\n" +
                "Please submit it before due date.\n" +
                "***");
        assertArrayEquals(result.trim(),printFiles());

    }

     */

    @Test
    void downsize() {
        String[] list={"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        LinkedList<String> employees=new LinkedList<>(Arrays.asList(list));
        MyCollections.downsize(employees,3);
        String[] expected={"Tom", "Bob", "Alice", "Trudy", "Denny"};
        LinkedList<String> expectedOutput=new LinkedList<>(Arrays.asList(expected));
        System.out.println(employees);
        assertEquals(expectedOutput,employees);
    }

    @Test
    void isBalanced() {
        // should return true
        assertEquals(true,MyCollections.isBalanced("System.out.println(list.get(0))"));
        // should return true
        assertEquals(true,MyCollections.isBalanced("[](3*5)^2"));
        // should return false
        assertEquals(false,MyCollections.isBalanced("[(2+3]*5)^2"));
        // should return false
        assertEquals(false,MyCollections.isBalanced("System.out.println(list.get(0)"));
        // should return false
        //assertEquals(false,MyCollections.isBalanced("[(3*5)]^2]"));
    }
}