/**
 * This class manage a type of cards that have an action in game 
 * and has 3 types
 * @author Mohammad Hassannejadi
 * @version 1.0
 */
public class ActionCard extends Card{

    private char type; // 'r' means reverse a , 's' means skip , 'd' means draw
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * constructor of this class that assign type
     * @param color color of card
     * @param type type of card 'r' means reverse a , 's' means skip , 'd' means draw
     */
    public ActionCard(char color , char type){
        super(color,20);
        this.type = type;
    }

    /**
     * getting type
     * @return the type
     */
    public char getType() {
        return type;
    }
    /**
     * show information of card
     */
    public void showCard(char color, int rotate){
        String colorStr = null;
        if(color == 'r')
            colorStr = "Red";
        else if(color == 'y')
            colorStr = "Yellow";
        else if(color == 'g')
            colorStr = "Green";
        else if(color == 'b')
            colorStr = "Blue";
        String rotateStr = null;
        if(rotate == 0)
            rotateStr ="Clockwise";
        else
            rotateStr = "Anticlockwise";

        if(this.getColor() == 'r'){ //red
            System.out.println("  ###########");
            System.out.println("  |   Red   |");
            if(type == 'r'){
                System.out.println("  | Reverse |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 's'){
                System.out.println("  |  Skip   |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 'd'){
                System.out.println("  | Draw +2 |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            System.out.println("  |         |");
            System.out.println("  ###########");
        }                                                   
        else if(this.getColor() == 'y'){ //yellow
            System.out.println("  ###########");
            System.out.println("  |  Yellow |");
            if(type == 'r'){
                System.out.println("  | Reverse |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 's'){
                System.out.println("  |  Skip   |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 'd'){
                System.out.println("  | Draw +2 |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            System.out.println("  |         |");
            System.out.println("  ###########");
        }
        else if(this.getColor() == 'g'){ //green
            System.out.println("  ###########");
            System.out.println("  |  Green  |");
            if(type == 'r'){
                System.out.println("  | Reverse |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 's'){
                System.out.println("  |  Skip   |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 'd'){
                System.out.println("  | Draw +2 |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            System.out.println("  |         |");
            System.out.println("  ###########");
        }
        else if(this.getColor() == 'b'){ //blue
            System.out.println("  ###########");
            System.out.println("  |  Blue   |");
            if(type == 'r'){
                System.out.println("  | Reverse |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 's'){
                System.out.println("  |  Skip   |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            else if(type == 'd'){
                System.out.println("  | Draw +2 |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
            }
            System.out.println("  |         |");
            System.out.println("  ###########");
        }
    }
}