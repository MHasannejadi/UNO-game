/**
 * This class manage a type of cards that has two types : simple wild , draw wild
 * @author Mohammad Hassannejadi
 * @version 1.0
 */
public class Wild extends Card{

    private char type; // 's' means simple wild , 'd' means draw wild
    
    /**
     * constructor of wild card
     * @param type type of card 's' means simple wild , 'd' means draw wild
     */
    public Wild(char type){
        super('c',50); //cyan color
        this.type = type;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }
    /**
     * show information of card
     */
    public void showCard(char color,int rotate){
        String colorStr;
        if(color == 'r')
            colorStr = "Red";
        else if(color == 'y')
            colorStr = "Yellow";
        else if(color == 'g')
            colorStr = "Green";
        else
            colorStr = "Blue";
        String rotateStr = null;
        if(rotate == 0)
            rotateStr ="Clockwise";
        else
            rotateStr = "Anticlockwise";
        System.out.println("  ###########");
        System.out.println("  |         |");
        if(type == 'd'){ // wild draw
            System.out.println("  | Wild +4 |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
        }
        else if(type == 's'){  //simple wild
            System.out.println("  |  Wild   |  Game Color: "+colorStr+"  rotate direction: "+rotateStr);
        }
        System.out.println("  |         |");
        System.out.println("  ###########");
    }
}