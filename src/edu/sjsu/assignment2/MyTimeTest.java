package edu.sjsu.assignment2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyTimeTest {

    @Test
    void printTimeDifference() {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        // save the original outputStream=console
        PrintStream original=System.out;
        // "Redirect" the new outputStream to outputStream object we created.
        System.setOut(new PrintStream(outputStream));
        // call the method
        MyTime.printTimeDifference("1800", "1900");
        assertEquals("1 hour(s) 0 minute(s)",outputStream.toString().trim());
    }
}