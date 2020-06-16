import java.util.Scanner;

/**
 * This class contains main function to run this program 
 * @author Mohammad Hassannejadi
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        int n; // number of players
        System.out.print("please enter number of players : ");
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        while(!(n>0&&n<16)){
            System.out.println("wrong players number. Try again");
            n = obj.nextInt();
        }
        Game UNO = new Game(n);
        UNO.play();
    }
}