package edu.sjsu.assignment1;

public class Mytest {
    public static void main(String[] args) {
        Card card=new Card("11H");
        String result=card.setDescription();
        System.out.println(result);
    }
}