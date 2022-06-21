package edu.sjsu.assignment1;

public class Card {
    private final String shortHand;
    private final String UNKNOWN = "Unknown";
    private String description;


    public Card(String shortHand) {
        this.shortHand = shortHand;
        this.description=setDescription();
    }

    private String getrank() {
        // set description based on the shorthand
        String rankShort = shortHand.substring(0 , shortHand.length() - 1);
        // get full rank based on the shorthand of rank
        return switch (rankShort) {
            case "A" -> "Ace";
            case "1" -> "One";
            case "2" -> "Two";
            case "3" -> "Three";
            case "4" -> "Four";
            case "5" -> "Five";
            case "6" -> "Six";
            case "7" -> "Seven";
            case "8" -> "Eight";
            case "9" -> "Nine";
            case "10" -> "Ten";
            case "J" -> "Jack";
            case "Q" -> "Queen";
            case "K" -> "King";
            default -> UNKNOWN;
        };
    };

    private String getsuit(){
        char suitShort=shortHand.charAt(shortHand.length()-1);
        return switch (suitShort){
            case 'H' -> "Hearts";
            case 'D' -> "Diamonds";
            case 'S' -> "Spades";
            case 'C' -> "Clubs";
            default -> UNKNOWN;
        };
    };

    public String setDescription() {
        String rank = getrank();
        String suit = getsuit();
        if (rank.equals(UNKNOWN) || suit.equals(UNKNOWN)) {
            return UNKNOWN;
        } else {
            return rank + " of " + suit;
        }
    }

    public String getDescription() {
        return this.description;
    }
}