/**
 * This class is a super class that has 3 subclass : simplecard , wild , actioncard 
 */
public class Card {
    
    private char color;
    private int score;
    public Card(char color,int score){
        this.color = color;
        this.score = score;
    }

    /**
     * @return the color
     */
    public char getColor() {
        return color;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the type
     */
    public char getType() {
        return ' ';
    } 
    /**
     * a super method that shows the information of card 
     * @param color
     * @param rotate
     */
    public void showCard(char color , int rotate){

    }
}