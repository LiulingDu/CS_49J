package edu.sjsu.assignment4;

import java.awt.event.WindowFocusListener;
import java.io.*;
import java.util.*;

public class MyCollections {
    public static void printFiles(Queue<File> files) throws IOException {
        while(!files.isEmpty()){
            File current=files.poll();
            BufferedReader br=new BufferedReader(new FileReader(current));
            String line=null;
            while((line=br.readLine())!=null) {
                System.out.println(line);
            }
            System.out.println("***");
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
            if(c=='(') parentheses.push(')');
                // else if [ push ]
            else if(c=='[') parentheses.push(']');
                // else if ) or ], check if the top of stack matches
                // if not, ( or the stack is empty ), return false;
                // if yes, pop the top
            else if(c==')'||c==']'){
                char top=parentheses.peek();
                if(c==top) parentheses.pop();
                else{
                    if((c!='(')||parentheses.empty()) return false;
                }
            }
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