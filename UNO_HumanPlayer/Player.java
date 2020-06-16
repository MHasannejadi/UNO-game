import java.util.ArrayList;
import java.util.Iterator;
/**
 * this class manage information of a player in game
 */
public class Player {

    private String name;
    private ArrayList<Card> playerCards;
    private ArrayList<Card> usableCards;
    /**
     * player constructor to assign name and new lists
     * @param name name of player
     */
    public Player(String name){
        this.name = name;
        playerCards = new ArrayList<Card>();
        usableCards = new ArrayList<Card>();
    }
    /**
     * get name 
     * @return name 
     */
    public String getName(){
        return name;
    }   
    /**
     * add a card to list of cards
     * @param card that we want to add
     */
    public void addCard(Card card){
        playerCards.add(card);
    }
    /**
     * remove a card from list
     * @param card that we want to remove
     */
    public void removeCard(Card card){
        playerCards.remove(card);
    }
    /**
     * get a card with its number in list
     * @param n number of card in list 
     * @return card
     */
    public Card getCard(int n){
        return playerCards.get(n-1);
    }
    /**
     * sub mthod of show card
     */
    public void showCards(){

    }
    /**
     * get score of player
     * @return score
     */
    public int getScore(){
        int score = 0;
        for (Card card : playerCards) {
            score+=card.getScore();
        }
        return score;
    }
    /**
     * get number of players card
     * @return number of players card
     */
    public int getPlayersCardNum(){
        return playerCards.size();
    }
    /**
     * find usable cards for a turn
     * @param nowCard card in the middle
     * @param nowColor color of game
     * @param forfeit forfeit of game
     */
    public void findUsableCards(Card nowCard , char nowColor, int forfeit){
        Iterator<Card> it = usableCards.iterator();
        while(it.hasNext()){
            it.next();
            it.remove();
        }
        int cont = 0;
        for(Card card1 : playerCards){
            if(nowCard instanceof ActionCard && nowCard.getType() == 'd' && card1 instanceof ActionCard && card1.getType() == 'd'){
                usableCards.add(card1);
                cont++;
            }
            if(nowCard instanceof Wild && nowCard.getType() == 'd' && card1 instanceof Wild && card1.getType() == 'd'){
                usableCards.add(card1);
                cont++;
            }
        }
        if(cont>0 && forfeit!=0){
            return;
        }
        for(Card card : playerCards){
            if((card instanceof SimpleCard || card instanceof ActionCard)&&((nowCard instanceof SimpleCard || nowCard instanceof ActionCard))&&card.getColor()==nowCard.getColor()){
                usableCards.add(card);         
            }
            else if(card instanceof SimpleCard && nowCard instanceof SimpleCard){
                if(card.getScore()==nowCard.getScore()){
                    usableCards.add(card);
                }
            }
            else if(card instanceof ActionCard && nowCard instanceof ActionCard){
                if(card.getType()==nowCard.getType()){
                    usableCards.add(card);
                }
            }
            if(nowCard instanceof Wild && card.getColor()==nowColor && card.getColor()!='c'){
                usableCards.add(card);
            }
            if(card instanceof Wild){
                if(card.getType() == 's'){ //simple wild
                    usableCards.add(card);
                }
            }
        }
        if(usableCards.size() == 0){
            for(Card card : playerCards){
                if(card instanceof Wild){
                    if(card.getType() == 'd'){ //draw wild
                        usableCards.add(card);
                    }
                }            
            }
        }
    }
    /**
     * check if card are usable for game or no
     * @param n number of card in list
     * @return true if are usable
     */
    public boolean isUsable(int n){
        Card selectedCard = playerCards.get(n-1);
        for(Card card : usableCards){
            if(card.equals(selectedCard)){
                return true;
            }
        }
        return false;
    }
    /**
     * check if this player has a usable card or no
     * @return true if has usable card
     */
    public boolean hasUsableCard(){
        if(usableCards.size()==0){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * check if this player has a wild draw card or no
     * @return true if has wild draw card
     */
    public boolean hasWildDraw(){
        for(Card card : playerCards){
            if(card instanceof Wild && card.getType()=='d'){
                return true;
            }
        }
        return false;
    }
    /**
     * check if this player has a draw card or no
     * @return true if has draw card
     */
    public boolean hasDraw(){
        for(Card card : playerCards){
            if(card instanceof ActionCard && card.getType()=='d'){
                return true;
            }
        }
        return false;
    }
}