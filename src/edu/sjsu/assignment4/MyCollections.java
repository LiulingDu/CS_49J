package edu.sjsu.assignment4;

import java.io.*;
import java.util.*;

public class MyCollections {
    /**
     * prints the files from the first to the last
     * @param files a collection of files
     * @return print files and *s is used to indicate the end of the file content.
     */
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

    /**
     * removes every nth element of a collection of employee names
     *
     * @param employees a collection of String
     * @param n         remove every nth element
     * @return print a collection of the string with remove every 3rd element
     */
    public static void downsize(LinkedList<String> employees, int n){
        ListIterator<String> listIterator=employees.listIterator();
        int index=0;

        while(listIterator.hasNext()){
            listIterator.next();
            index++;
            if(index % n ==0){
                listIterator.remove();
            }
        }
        System.out.println(employees);
    }

    /**
     * checks if a String has balanced parentheses
     * @param exp String
     * @return whether it is a balanced parentheses
     */
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
        downsize(employees,3);
        System.out.println("after: " + employees);
    }
}