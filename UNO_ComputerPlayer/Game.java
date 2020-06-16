import java.util.*;
/**
 * This class contains a map and its play method to manage game generally and 
 * get input and connect with map class to do different actions of game
 * @author Mohammad Hassannejadi
 * @version 1.0 
 */
public class Game {
    
    private int n; // number of players
    private ArrayList<Player> players;
    private ArrayList<Player> copyPlayers;
    private ArrayList<Card> storeCards; //remaining cards
    private Player nowPlayer;
    private Card nowCard;
    private char nowColor;
    private int rotate; // 0 = clockwise , 1 = anticlockwise
    private int forfeit; //forfeit for draw and wildsraw cards in every turn
    /**
     * constructor of game to new lists of game
     * @param n number of players
     */
    public Game(int n){
        this.n = n;
        players = new ArrayList<Player>();
        storeCards = new ArrayList<Card>();
        addPlayers();
        copyPlayers = new ArrayList<Player>();
        for(Player player : players){
            copyPlayers.add(player);
        }
        addCards();
        nowPlayer = new Player(0);
        nowCard = new Card('a', 0);
        rotate = 0;
        forfeit = 0;
    }

    /**
     * add players to list of players
     */
    public void addPlayers(){
        Scanner obj = new Scanner(System.in);
        for(int i = 0 ; i<n ; i++){
            Player player = new Player(i+1);
            players.add(player);
            System.out.println();
        }
    }
    /**
     * add cards to list of cards in the first of game
     */
    public void addCards(){

        for(int i = 0 ; i<10 ; i++){
            Card card = new SimpleCard('r', i); // red cards
            storeCards.add(card);
        }
        for(int i = 1 ; i<10 ; i++){
            Card card = new SimpleCard('r', i);
            storeCards.add(card);
        }
        for(int i = 0 ; i<10 ; i++){
            Card card = new SimpleCard('y', i); // yellow cards
            storeCards.add(card);
        }
        for(int i = 1 ; i<10 ; i++){
            Card card = new SimpleCard('y', i);
            storeCards.add(card);
        }
        for(int i = 0 ; i<10 ; i++){
            Card card = new SimpleCard('g', i); //green cards
            storeCards.add(card);
        }
        for(int i = 1 ; i<10 ; i++){
            Card card = new SimpleCard('g', i); 
            storeCards.add(card);
        }
        for(int i = 0 ; i<10 ; i++){ 
            Card card = new SimpleCard('b', i);  //blue cards
            storeCards.add(card);
        }
        for(int i = 1 ; i<10 ; i++){
            Card card = new SimpleCard('b', i);
            storeCards.add(card);
        }

        /****************************************************************************/

        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('r','r'); //first r = red , second r = reverse card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('r','s'); // r = red , s = skip card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('r','d'); // r = red , d = draw card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('y','r'); // y = yellow , second r = reverse card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('y','s'); //s = skip card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('y','d'); //d = draw card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('g','r'); // g = green , second r = reverse card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('g','s'); //s = skip card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('g','d'); //d = draw card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('b','r'); // b = blue , second r = reverse card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('b','s'); //s = skip card
            storeCards.add(card);
        }
        for(int i = 0 ; i<2 ; i++){
            Card card = new ActionCard('b','d'); //d = draw card
            storeCards.add(card);
        }

        /***************************************************************************/

        for(int i = 0 ; i<4 ; i++){
            Card card = new Wild('s'); // s = simple wild
            storeCards.add(card);
            Card card1 = new Wild('d'); // d = draw wild
            storeCards.add(card1);
        }

    }

    /**
     * get score of player and return name of him
     * @return player name
     */
    public int getPlayerNumber(int score) {
        for(Player player1 : copyPlayers){
            if(score == player1.getScore()){
                copyPlayers.remove(player1);
                return player1.getNumber();
            }
        }
        return 0;
    }
    /**
     * check if the game ends or not
     */
    public boolean checkend(){
        for(Player player : players){
            if(player.getPlayersCardNum() == 0){
                return true;
            }
        }
        return false;
    }
    /**
     * show result of game and scores in the end of game
     */
    public void showResult(){
        for(Player player : players){
            if(player.getPlayersCardNum() == 0){
                System.out.println("Player"+player.getNumber()+" Wins :)");
                break;
            }
        }
        ArrayList<Integer> scores = new ArrayList<Integer>();
        System.out.println("Scores:");
        for(Player player : players){
            scores.add(player.getScore());
        }
        Collections.sort(scores);
        for(int score : scores){
            System.out.println(getPlayerNumber(score) + ": " + score);
        }
    }
    /**
     * show informatoin of game in console
     */
    public void show(){
        
        System.out.println();
        System.out.println("**************************************************************************************\n");
        nowCard.showCard(nowColor,rotate);
        System.out.println();
        System.out.println("turn: Player1");
        System.out.println();
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            Card card = nowPlayer.getCard(i+1);
            if(card.getColor() == 'r'){ //red
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'y'){ //yellow
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'g'){ //green
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'b'){ //blue
                System.out.print("  ###########");
            }
            else{
                System.out.print("  ###########");
            }

        }
        System.out.println();
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            Card card = nowPlayer.getCard(i+1);
            if(card.getColor() == 'r'){ //red
                System.out.print("  |   Red   |");
            }
            else if(card.getColor() == 'y'){ //yellow
                System.out.print("  |  Yellow |");
            }
            else if(card.getColor() == 'g'){ //green
                System.out.print("  |  Green  |");
            }
            else if(card.getColor() == 'b'){ //blue
                System.out.print("  |  Blue   |");
            }
            else{ //cyin
                System.out.print("  |         |");
            }
        }
        System.out.println();
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            Card card = nowPlayer.getCard(i+1);
            char type = card.getType();
            if(card instanceof ActionCard){
                if(card.getColor() == 'r'){ //red
                    if(type == 'r'){
                        System.out.print("  | Reverse |");
                    }
                    else if(type == 's'){
                        System.out.print("  |  Skip   |");
                    }
                    else if(type == 'd'){
                        System.out.print("  | Draw +2 |");
                    }
                }
                else if(card.getColor() == 'y'){ //yellow
                    if(type == 'r'){
                        System.out.print("  | Reverse |");
                    }
                    else if(type == 's'){
                        System.out.print("  |  Skip   |");
                    }
                    else if(type == 'd'){
                        System.out.print("  | Draw +2 |");
                    }
                }
                else if(card.getColor() == 'g'){ //green
                    if(type == 'r'){
                        System.out.print("  | Reverse |");
                    }
                    else if(type == 's'){
                        System.out.print("  |  Skip   |");
                    }
                    else if(type == 'd'){
                        System.out.print("  | Draw +2 |");
                    }
                }
                else if(card.getColor() == 'b'){ //blue
                    if(type == 'r'){
                        System.out.print("  | Reverse |");
                    }
                    else if(type == 's'){
                        System.out.print("  |  Skip   |");
                    }
                    else if(type == 'd'){
                        System.out.print("  | Draw +2 |");
                    }
                }
            }
            else if(card instanceof Wild){
                if(type == 'd'){ // wild draw
                    System.out.print("  | Wild +4 |");
                }
                else if(type == 's'){  //simple wild
                    System.out.print("  |  Wild   |");
                }
            }
            else{
                int num = card.getScore();
                if(card.getColor() == 'r'){ //red
                    System.out.print("  |    "+num+"    |");                 
                }
                else if(card.getColor() == 'y'){ //yellow
                    System.out.print("  |    "+num+"    |");
                }
                else if(card.getColor() == 'g'){ //green
                    System.out.print("  |    "+num+"    |");
                }
                else if(card.getColor() == 'b'){ //blue
                    System.out.print("  |    "+num+"    |");
                }
            }
        }
        System.out.println();
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            Card card = nowPlayer.getCard(i+1);
            if(card.getColor() == 'r'){ //red
                System.out.print("  |         |");
            }
            else if(card.getColor() == 'y'){ //yellow
                System.out.print("  |         |");
            }
            else if(card.getColor() == 'g'){ //green
                System.out.print("  |         |");
            }
            else if(card.getColor() == 'b'){ //blue
                System.out.print("  |         |");
            }
            else{
                System.out.print("  |         |");
            }         
        }
        System.out.println();
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            Card card = nowPlayer.getCard(i+1);
            if(card.getColor() == 'r'){ //red
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'y'){ //yellow
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'g'){ //green
                System.out.print("  ###########");
            }
            else if(card.getColor() == 'b'){ //blue
                System.out.print("  ###########");
            }
            else{
                System.out.print("  ###########");
            }

        }
        System.out.println();
        
        for(int i = 0 ; i<nowPlayer.getPlayersCardNum() ; i++){
            int j = i+1;
            System.out.print("       "+j+"     ");
        }
        System.out.println();
        System.out.println();
        
        for(Player player : players){
            System.out.println("Player"+player.getNumber()+" has "+player.getPlayersCardNum()+" cards.");
           
        }
        System.out.println();
    }
    /**
     * clear the console
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    /**
     * play method is manage inputs and pass them to map and manage game generally 
     */
    public void play(){
        
        try{
            Scanner obj = new Scanner(System.in);

            for(int j = 0; j<n ; j++){ //random distribution cards
                Random r = new Random();
                for(int i = 0 ; i<7 ; i++){
                    int ranNum = r.nextInt(storeCards.size());
                    Card card = storeCards.get(ranNum); 
                    players.get(j).addCard(card);
                    storeCards.remove(card);
                }
            }

            Random r = new Random();
            int nowPlayerNum = r.nextInt(n);
            nowPlayer = players.get(nowPlayerNum);
            
            int firstCardNum = r.nextInt(storeCards.size());
            while(storeCards.get(firstCardNum) instanceof Wild){
                firstCardNum = r.nextInt(storeCards.size());
            }
            nowCard = storeCards.get(firstCardNum);
            nowColor = nowCard.getColor();
            storeCards.remove(nowCard);

            while(!checkend()){
                
                
                if(nowPlayer.getNumber()==1) show();
                else {
                    System.out.println();
                    System.out.println("**************************************************************************************\n");
                    nowCard.showCard(nowColor,rotate);
                    System.out.println();
                    System.out.println("turn: Player"+nowPlayer.getNumber());
                    System.out.println();
                    for(Player player : players){
                        System.out.println("Player"+player.getNumber()+" has "+player.getPlayersCardNum()+" cards.");
                    }
                    System.out.println();
                    System.out.println("Press a key to resume");
                    obj.nextLine();
                    obj.nextLine();
                }
                nowPlayer.findUsableCards(nowCard, nowColor , forfeit);
                if(nowPlayer.hasUsableCard()){
                    
                    if(nowPlayer.getNumber()==1) System.out.print("Please select a card with number: ");
                    
                }
                else{
                    if(nowPlayer.getNumber()==1){
                        System.out.println("You don't have any usable card :(");
                        obj.nextLine();
                    } 
                    
                    Card ranCard = storeCards.get(r.nextInt(storeCards.size()));
                    storeCards.remove(ranCard);
                    nowPlayer.addCard(ranCard);
                    nowPlayer.findUsableCards(nowCard, nowColor , forfeit);
                    if(nowPlayer.getNumber()==1) show();
                    if(nowPlayer.hasUsableCard()){
                        if(nowPlayer.getNumber()==1) System.out.print("Please select a card with number: ");
                    }
                    else{
                        players.set(nowPlayerNum%n , nowPlayer);
                        if(rotate == 0 ){
                            nowPlayerNum++;
                        }
                        else{
                            nowPlayerNum+=n-1;
                        }
                        nowPlayer = players.get(nowPlayerNum%n);
                        if(nowPlayer.getNumber()==1) System.out.println("You don't have any usable card :(");
                        continue;
                    }
                }   
                if(nowPlayer.getNumber()==1){
                    int cardNum = obj.nextInt();
                    while(!nowPlayer.isUsable(cardNum)){
                    System.out.println("Wrong card number!!! please select again.");
                    cardNum = obj.nextInt();

                    }
                    storeCards.add(nowCard);
                    nowCard = nowPlayer.getCard(cardNum);
                }
                else{
                    storeCards.add(nowCard);
                    int cardNum = nowPlayer.selectRandomCard();
                    nowCard = nowPlayer.getUsableCard(cardNum);
                } 
                
                if(!(nowCard instanceof Wild)){
                    nowColor = nowCard.getColor();
                }
                nowPlayer.removeCard(nowCard);
                if(nowCard instanceof Wild){
                    if(nowPlayer.getNumber()==1){
                        System.out.println("Please select one color:");
                        System.out.println("1.Red\n2.Yellow\n3.Green\n4.Blue");
                        int colorNum = obj.nextInt();
                        switch(colorNum){
                            case 1:
                                nowColor = 'r';
                                break;
                            case 2:
                                nowColor = 'y';
                                break;  
                            case 3:
                                nowColor = 'g';
                                break; 
                            case 4:
                                nowColor = 'b';
                                break;
                        }
                         
                    }
                    else{
                        int ran = r.nextInt(4)+1;
                        switch(ran){
                            case 1:
                                nowColor = 'r';
                                break;
                            case 2:
                                nowColor = 'y';
                                break;  
                            case 3:
                                nowColor = 'g';
                                break; 
                            case 4:
                                nowColor = 'b';
                                break;
                        }
                    }
                    if(nowCard.getType()=='d'){ //wild draw
                        Player nextPlayer;
                        if(rotate == 0){ //clockwise
                            nextPlayer = players.get((nowPlayerNum+1)%n);
                        }
                        else{
                            nextPlayer = players.get((nowPlayerNum+n-1)%n);
                        }
                        forfeit += 4;
                        if(nextPlayer.hasWildDraw()){
                            forfeit+=4;
                            players.set(nowPlayerNum%n, nowPlayer);
                            if(rotate == 0){
                                nowPlayerNum++;
                            }
                            else{
                                nowPlayerNum+=n-1;
                            }
                            nowPlayer = players.get(nowPlayerNum%n);
                            continue;
                        }
                        else{
                            players.set(nowPlayerNum%n, nowPlayer);
                            for(int i = 0 ; i<forfeit ; i++){
                                Card ranCard;
                                int randomCardNum = r.nextInt(storeCards.size());
                                ranCard = storeCards.get(randomCardNum);
                                storeCards.remove(ranCard);
                                nextPlayer.addCard(ranCard);
                            }
                            forfeit = 0; 
                            if(rotate == 0){
                                players.set((nowPlayerNum+1)%n, nextPlayer);
                                nowPlayerNum+=2;
                            }
                            else{
                                players.set((nowPlayerNum+n-1)%n, nextPlayer);
                                nowPlayerNum+=n-2;
                            }
                            nowPlayer = players.get(nowPlayerNum%n);
                        }
                    }
                    else{ //simple wild
                        forfeit = 0;
                        players.set(nowPlayerNum%n, nowPlayer);
                        if(rotate == 0){
                            nowPlayerNum++;
                        }
                        else{
                            nowPlayerNum+=n-1;
                        }
                        nowPlayer = players.get(nowPlayerNum%n);
                        continue;
                    }
                }
                else if(nowCard instanceof ActionCard){
                    if(nowCard.getType() == 'r'){ //reverse
                        forfeit = 0;
                        if(rotate == 0){
                            rotate = 1;
                        }
                        else{
                            rotate = 0;
                        }
                        players.set(nowPlayerNum%n, nowPlayer);
                        if(rotate == 0){
                            nowPlayerNum++;
                        }
                        else{
                            nowPlayerNum+=n-1;
                        }
                        nowPlayer = players.get(nowPlayerNum%n);
                        continue;
                    }
                    else if(nowCard.getType() == 's'){ //skip
                        forfeit = 0;
                        players.set(nowPlayerNum%n, nowPlayer);
                        if(rotate == 0){
                            nowPlayerNum+=2;
                        }
                        else{
                            nowPlayerNum+=n-2;
                        }
                        nowPlayer = players.get(nowPlayerNum%n);
                        continue;
                    }
                    else if(nowCard.getType() == 'd'){ //simple draw
                        Player nextPlayer;
                        if(rotate == 0){ //clockwise
                            nextPlayer = players.get((nowPlayerNum+1)%n);
                        }
                        else{
                            nextPlayer = players.get((nowPlayerNum+n-1)%n);
                        }
                        forfeit+=2;
                        if(nextPlayer.hasDraw()){
                            forfeit+=2;
                            players.set(nowPlayerNum%n, nowPlayer);
                            if(rotate == 0){
                                nowPlayerNum++;
                            }
                            else{
                                nowPlayerNum+=n-1;
                            }
                            nowPlayer = players.get(nowPlayerNum%n);
                            continue;
                        }
                        else{
                            players.set(nowPlayerNum%n, nowPlayer);
                            for(int i = 0 ; i<forfeit ; i++){
                                Card ranCard;
                                int randomCardNum = r.nextInt(storeCards.size());
                                ranCard = storeCards.get(randomCardNum);
                                storeCards.remove(ranCard);
                                nextPlayer.addCard(ranCard);
                            }
                            forfeit = 0; 
                            if(rotate == 0){
                                players.set((nowPlayerNum+1)%n, nextPlayer);
                                nowPlayerNum+=2;
                            }
                            else{
                                players.set((nowPlayerNum+n-1)%n, nextPlayer);
                                nowPlayerNum+=n-2;
                            }
                            nowPlayer = players.get(nowPlayerNum%n);
                        }
                    }
                }
                else if(nowCard instanceof SimpleCard){
                    forfeit = 0;
                    players.set(nowPlayerNum%n, nowPlayer);
                    if(rotate == 0){
                        nowPlayerNum++;
                    }
                    else{
                        nowPlayerNum+=n-1;
                    }
                    nowPlayer = players.get(nowPlayerNum%n);
                    continue;
                }
            }
            
            showResult();     
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
}