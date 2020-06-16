/**
 * This class manage a type of cards that is simple and only has 
 * color and number
 * @author Mohammad Hassannejadi
 * @version 1.0
 */
public class SimpleCard extends Card{
    
    private int number;
    /**
     * constructor of this class that assign color and number  of card
     * @param color color of card
     * @param type type of card 'r' means reverse a , 's' means skip , 'd' means draw
     */
    public SimpleCard(char color , int number){
        super(color, number);
        this.number = number;
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

        if(color == 'r'){ //red
            System.out.println("  ###########");
        }
        else if(color == 'y'){ //yellow
            System.out.println("  ###########");
        }
        else if(color == 'g'){ //green
            System.out.println("  ###########");
        }
        else if(color == 'b'){ //blue
            System.out.println("  ###########");
        }

        if(color == 'r'){ //red
            System.out.println("  |   Red   |");
        }
        else if(color == 'y'){ //yellow
            System.out.println("  |  Yellow |");
        }
        else if(color == 'g'){ //green
            System.out.println("  |  Green  |");
        }
        else if(color == 'b'){ //blue
            System.out.println("  |  Blue   |");
        }
        if(rotate == 0){ // Clockwise
            if(color == 'r'){ //red
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: Clockwise");                 
            }
            else if(color == 'y'){ //yellow
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: Clockwise");
            }
            else if(color == 'g'){ //green
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: Clockwise");
            }
            else if(color == 'b'){ //blue
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: Clockwise");
            }
        }
        else{
            if(color == 'r'){ //red
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: AntiClockwise");                 
            }
            else if(color == 'y'){ //yellow
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: AntiClockwise");
            }
            else if(color == 'g'){ //green
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: AntiClockwise");
            }
            else if(color == 'b'){ //blue
                System.out.println("  |    "+number+"    |  Game Color: "+colorStr+"  rotate direction: AntiClockwise");
            }
        }
        
        if(color == 'r'){ //red
            System.out.println("  |         |");
        }
        else if(color == 'y'){ //yellow
            System.out.println("  |         |");
        }
        else if(color == 'g'){ //green
            System.out.println("  |         |");
        }
        else if(color == 'b'){ //blue
            System.out.println("  |         |");
        }

        if(color == 'r'){ //red
            System.out.println("  ###########");
        }
        else if(color == 'y'){ //yellow
            System.out.println("  ###########");
        }
        else if(color == 'g'){ //green
            System.out.println("  ###########");
        }
        else if(color == 'b'){ //blue
            System.out.println("  ###########");
        }

    }

}