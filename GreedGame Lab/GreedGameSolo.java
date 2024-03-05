import java.util.*;
/*
 * @author: Bradley Bell
 * @version: March 4, 2024
 */
public class GreedGameSolo
{
    private Scanner kb;
    private int total;
    public GreedGameSolo(){
        kb = new Scanner(System.in);
        total = 0;
    }
    public static void main(String[] args)
    {
        GreedGameSolo player = new GreedGameSolo();
        player.play(1);
        player.play(2);
        player.play(3);
        player.play(4);
        player.play(5);
        player.say("END GAME! \nTotal Points: " + player.total);
    }
    public void play(int rounds) {
        int[] round = new int[5];
        System.out.println();
        String answer = ask("Round: " + rounds + " Do you want to play?");
        int r1;
        int r2;
        int roundTotal;
        while (answer.charAt(0) == 'y') {
            r1=roll();
            r2=roll();
            if (r1 == 2 || r2 == 2) {
                round[rounds-1] = 0;
                roundTotal = 0;
                say("You rolled a 2. Round Ended, 0 points");
                break;
            }
            else {
                roundTotal = r1+r2;
            }
            round[rounds-1] += roundTotal;
            answer = ask("We rolled for " + roundTotal + " for a total of " + round[rounds-1] + ". Do you want to continue? Y or N");
            if(answer.charAt(0) == 'n') {
                say("Round Ended. You sat down with " + round[rounds-1] + " points. Total: " + calculateTotal(round));
            }
        }
    }
    public int calculateTotal(int[] arr) {
        for(int i =0; i < arr.length; i++)
            total += arr[i];
        return total;
    }
    public String ask(String message){
        System.out.print(message+" ");
        return kb.nextLine();
    }
    public static int roll(){
        return 1 + (int)(6*Math.random() );
    }
    public static void say(String s){
        System.out.println(s);
    }
}
