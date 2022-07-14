package edu.sjsu.assignment4;

import java.awt.event.WindowFocusListener;
import java.io.File;
import java.util.*;

public class MyCollections {
    public static void printFiles(Queue<File> files) {
        while(!files.isEmpty()){
            File current=files.poll();
            print(current);
        }
    }

    private static void print(File file){

    }

    public static void downsize(LinkedList<String> employees,int n){
        ListIterator<String> listIterator=employees.listIterator();
        int index=0;

        while(listIterator.hasNext()){
            listIterator.next();
            index++;
            if(index % n ==0){
                listIterator.remove();
            }
        }
    }

    public static boolean isBalanced(String exp){
        Stack<Character> parentheses= new Stack<>();
        for(char c:exp.toCharArray()){
            // if ( push )
            // else if [ push ]
            // else if ) or ], check if the top of stack matches
               // if not ( or the stack is empty ), return false;
               // if yes, pop the top
        }
        return parentheses.isEmpty();
    }


    public static void main(String[] args) {
        String[] list={"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        LinkedList<String> employees=new LinkedList<>(Arrays.asList(list));
        System.out.println("before: " + employees);
        downsize(employees,3);
        System.out.println("after: " + employees);
    }
}
